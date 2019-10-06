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
            String nextLast = pathToNextLast(last);
            // todo: continue here
        }
        size++;
        return entry;
    }

    private String pathToNextLast(String last) {
        if (isLastInRow(last)) {
            char[] chars = new char[last.length() + 1];
            Arrays.fill(chars, '0');
            return String.valueOf(chars);
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

    @Override
    public Entry<K, V> removeMin() {
        Entry<K, V> entry = root.getEntry();
        root = null;
        size--;
        return entry;
    }
}
