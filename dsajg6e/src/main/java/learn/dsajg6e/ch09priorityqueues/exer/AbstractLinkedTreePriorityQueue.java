package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch09priorityqueues.AbstractPriorityQueue;
import learn.dsajg6e.ch09priorityqueues.Entry;

public abstract class AbstractLinkedTreePriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    protected HTNode<K, V> root;
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Entry<K, V> min() {
        if (isEmpty()) {
            return null;
        }
        return root.getEntry();
    }

    protected HTNode<K, V> findLeftLeaf() {
        HTNode<K, V> n = root;
        while (n.getLeft() != null) {
            n = n.getLeft();
        }
        return n;
    }

    protected void upHeap(HTNode<K, V> node) {
        var parent = node.getParent();
        while (parent != null && compare(parent.getEntry(), node.getEntry()) > 0) {
            node.swapEntries(parent);
            node = parent;
            parent = parent.getParent();
        }
    }

    protected HTNode<K, V> rightSiblingOfParent(HTNode<K, V> node) {
        var parent = node.getParent();
        if (parent != null) {
            var superParent = parent.getParent();
            if (superParent != null) {
                return superParent.getRight();
            }
        }
        return null;
    }

    protected void downHeap(HTNode<K, V> node) {
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
