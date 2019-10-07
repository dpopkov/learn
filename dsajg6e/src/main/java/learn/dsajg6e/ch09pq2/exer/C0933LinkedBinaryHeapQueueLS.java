package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch09pq2.Entry;

import java.util.Arrays;

/**
 * C-9.33
 * Finds the last node using binary string representation.
 * LS - Last by String.
 * Uses path from the root to a given node by means of a binary string,
 * where 0 means "go to the left child", and 1 means "go to the right child".
 */
public class C0933LinkedBinaryHeapQueueLS<K, V> extends AbstractLinkedBinaryTreeHeapQueue<K, V> {
    private String last;

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> entry = new PQEntry<>(key, value);
        BNode<K, V> node = new BNode<>(entry);
        if (isEmpty()) {
            root = node;
            last = "";
        } else {
            String pathToNext = pathToNextLast(last);
            String pathToParent = pathToNext.substring(0, pathToNext.length() - 1);
            BNode<K, V> parent = findByPath(pathToParent);
            parent.addChild(node);
            upHeap(node);
            last = pathToNext;
        }
        size++;
        return entry;
    }

    @Override
    public Entry<K, V> removeMin() {
        Entry<K, V> entry = root.getEntry();
        if (size == 1) {
            root = null;
        } else {
            BNode<K, V> lastNode = findByPath(last);
            swap(root, lastNode);
            removeFromParent(lastNode);
            downHeap(root);
            last = pathToPrevious(last);
        }
        size--;
        return entry;
    }

    private String pathToPrevious(String path) {
        if (isFirstInRow(path)) {
            return stringOfOnes(path.length() - 1);
        }
        return minusOne(path);
    }

    private BNode<K, V> findByPath(String path) {
        BNode<K, V> node = root;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '0') {
                node = node.getLeft();
            } else if (c == '1') {
                node = node.getRight();
            } else {
                throw new IllegalArgumentException("Path can not contain character: " + c);
            }
        }
        return node;
    }

    private String pathToNextLast(String last) {
        if (isLastInRow(last)) {
            return stringOfZeroes(last.length() + 1);
        }
        return addOne(last);
    }

    private boolean isLastInRow(String path) {
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }

    private boolean isFirstInRow(String path) {
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '1') {
                return false;
            }
        }
        return true;
    }

    private static String stringOf(char ch, int length) {
        char[] chars = new char[length];
        Arrays.fill(chars, ch);
        return String.valueOf(chars);
    }

    private static String stringOfZeroes(int length) {
        return stringOf('0', length);
    }

    private static String stringOfOnes(int length) {
        return stringOf('1', length);
    }

    private static String addOne(String s) {
        char[] chars = s.toCharArray();
        final int last = chars.length - 1;
        if (chars[last] == '0') {
            chars[last] = '1';
            return String.valueOf(chars);
        }
        chars[last] = '0';
        boolean shift = true;
        for (int i = last - 1; i >= 0; i--) {
            if (shift) {
                if (chars[i] == '0') {
                    chars[i] = '1';
                    shift = false;
                } else if (chars[i] == '1') {
                    chars[i] = '0';
                }
            }
        }
        return String.valueOf(chars);
    }

    private static String minusOne(String s) {
        char[] chars = s.toCharArray();
        final int last = chars.length - 1;
        for (int i = last; i >= 0; i--) {
            if (chars[i] == '1') {
                chars[i] = '0';
                break;
            } else if (chars[i] == '0') {
                chars[i] = '1';
            }
        }
        return String.valueOf(chars);
    }
}
