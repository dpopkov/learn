package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch09priorityqueues.AbstractPriorityQueue;
import learn.dsajg6e.ch09priorityqueues.Entry;

/**
A binary linked tree representation of a priority queue ADT.
 */
public class C0931HeapLinkedTreePQueue<K, V> extends AbstractPriorityQueue<K, V> {

    protected HTNode<K, V> root;
    private HTNode<K, V> last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> entry = new PQEntry<>(key, value);
        HTNode<K, V> node = new HTNode<>(entry);
        if (isEmpty()) {
            root = node;
            last = node;
            size = 1;
        } else {
            last = addNext(node);
            size++;
            upHeap(node);
        }
        return entry;
    }

    private HTNode<K, V> addNext(HTNode<K, V> next) {
        if (last == root) {
            last.add(next);
            return next;
        }
        var parentOfLast = last.getParent();
        if (parentOfLast.isLeft(last)) {
            parentOfLast.add(next);
        } else {
            var parentForNext = findParentForExtendingBottomRow(last);
            if (parentForNext != null) {
                parentForNext.add(next);
            } else {
                parentForNext = findLeftLeaf();
                parentForNext.add(next);
            }
        }
        return next;
    }

    private HTNode<K, V> findParentForExtendingBottomRow(HTNode<K, V> node) {
        var parent = node.getParent();
        if (parent != null) {
            var superParent = parent.getParent();
            if (superParent != null) {
                return superParent.getRight();
            }
        }
        return null;
    }

    private HTNode<K, V> findLeftLeaf() {
        HTNode<K, V> n = root;
        while (n.getLeft() != null) {
            n = n.getLeft();
        }
        return n;
    }

    private void upHeap(HTNode<K, V> node) {
        var parent = node.getParent();
        while (parent != null && compare(parent.getEntry(), node.getEntry()) > 0) {
            node.swapEntries(parent);
            node = parent;
            parent = parent.getParent();
        }
    }

    @Override
    public Entry<K, V> min() {
        if (isEmpty()) {
            return null;
        }
        return root.getEntry();
    }

    @Override
    public Entry<K, V> removeMin() {
        Entry<K, V> minEntry = root.getEntry();
        root.swapEntries(last);
        HTNode<K, V> parentLast = last.getParent();
        HTNode<K, V> prev = findPrev(last);
        if (parentLast != null) {
            parentLast.removeChild(last);
        }
        last = prev;
        size--;
        downHeap(root);
        return minEntry;
    }

    private HTNode<K, V> findPrev(HTNode<K, V> node) {
        HTNode<K, V> p = node.getParent();
        if (p == null) {
            return null;
        } else if (p.isRight(node)) {
            return p.getLeft();
        } else if (p.isLeft(node)) {
            HTNode<K, V> rightSibling = findRightSibling(node);
            if (rightSibling != null) {
                return rightSibling;
            } else {
                return findMostRight(); // it works when last is the first in row only!!!
            }
        }
        return p;
    }

    private HTNode<K, V> findRightSibling(HTNode<K, V> node) {
        var p = node.getParent();
        if (p != null) {
            var pp = p.getParent();
            if (pp != null) {
                var leftParent = pp.getLeft();
                if (leftParent != null) {
                    return leftParent.getRight();
                }
            }
        }
        return null;
    }

    private HTNode<K, V> findMostRight() {
        HTNode<K, V> n = root;
        while (n.getRight() != null) {
            n = n.getRight();
        }
        return n;
    }

    private void downHeap(HTNode<K, V> node) {
        HTNode<K, V> target;
        while (!node.isLeaf()) {
            if (node.getRight() == null) {
                target = node.getLeft();
            } else if (compare(node.getLeft().getEntry(), node.getRight().getEntry()) < 0) {
                target = node.getLeft();
            } else {
                target = node.getRight();
            }
            if (compare(node.getEntry(), target.getEntry()) > 0) {
                node.swapEntries(target);
                node = target;
            } else {
                break;
            }
        }
    }
}
