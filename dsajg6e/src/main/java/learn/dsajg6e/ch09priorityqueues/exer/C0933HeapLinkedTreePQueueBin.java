package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch09priorityqueues.Entry;
import learn.dsajg6e.ch09priorityqueues.PQEntry;

public class C0933HeapLinkedTreePQueueBin<K, V> extends AbstractLinkedTreePriorityQueue<K, V> {
    private static final char TURN_LEFT = '0';
    private static final char TURN_RIGHT = '1';

    private String path = "";

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        Entry<K, V> entry = new PQEntry<>(key, value);
        HTNode<K, V> newest = new HTNode<>(entry);
        if (isEmpty()) {
            root = newest;
            path = "";
            size = 1;
        } else {
            if (shouldStartRow()) {
                findLeftLeaf().add(newest);
                resetPathToStartOfRow();
            } else {
                HTNode<K, V> last = getLast();
                if (last.isLeftChild()) {
                    last.getParent().add(newest);
                    replacePathLastChar(TURN_RIGHT);
                } else {
                    rightSiblingOfParent(last).add(newest);
                    replacePathLast2Chars(TURN_RIGHT, TURN_LEFT);
                }
            }
            size++;
            upHeap(newest);
        }
        return entry;
    }

    private void resetPathToStartOfRow() {
        path = path.replace(TURN_RIGHT, TURN_LEFT) + TURN_LEFT;
    }

    private void replacePathLastChar(char ch) {
        path = path.substring(0, path.length() - 1) + ch;
    }

    private void replacePathLast2Chars(char ch1, char ch2) {
        path = path.substring(0, path.length() - 2) + ch1 + ch2;
    }

    private boolean shouldStartRow() {
        boolean isLastInRow = true;
        int len = path.length();
        for (int i = 0; i < len; i++) {
            if (path.charAt(i) == '0') {
                isLastInRow = false;
                break;
            }
        }
        return isLastInRow;
    }

    private HTNode<K, V> getLast() {
        HTNode<K, V> n = root;
        int len = path.length();
        for (int i = 0; i < len; i++) {
            char ch = path.charAt(i);
            if (ch == '0') {
                n = n.getLeft();
            } else {
                n = n.getRight();
            }
        }
        return n;
    }

    @Override
    public Entry<K, V> removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, V> min = root.getEntry();
        HTNode<K, V> last = getLast();
        root.swapEntries(last);
        HTNode<K, V> p = last.getParent();
        if (p != null) {
            p.removeChild(last);
            downHeap(root);
        } else {
            root = null;
        }
        size--;
        updatePath();
        return min;
    }

    private void updatePath() {
        if (pathOnStartOfRow()) {
            resetPathToEndOfPrevRow();
        } else {
            if (path.charAt(path.length() - 1) == TURN_RIGHT) {
                replacePathLastChar(TURN_LEFT);
            } else {
                replacePathLast2Chars(TURN_LEFT, TURN_RIGHT);
            }
        }
    }

    private void resetPathToEndOfPrevRow() {
        int len = path.length();
        if (len > 0) {
            path = path.substring(0, len - 1).replace(TURN_LEFT, TURN_RIGHT);
        }
    }

    private boolean pathOnStartOfRow() {
        int len = path.length();
        for (int i = 0; i < len; i++) {
            if (path.charAt(i) == TURN_RIGHT) {
                return false;
            }
        }
        return true;
    }
}
