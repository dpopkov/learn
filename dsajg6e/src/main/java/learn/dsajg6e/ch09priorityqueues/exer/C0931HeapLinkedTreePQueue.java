package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch09priorityqueues.AbstractPriorityQueue;
import learn.dsajg6e.ch09priorityqueues.Entry;

/**
A binary linked tree representation of a priority queue ADT.
 */
public class C0931HeapLinkedTreePQueue<K, V> extends AbstractPriorityQueue<K, V> {

    private static class Node<K, V> {
        private Entry<K, V> entry;
        private Node<K, V> parent;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(Entry<K, V> entry) {
            this(entry, null, null, null);
        }

        public Node(Entry<K, V> entry, Node<K, V> parent, Node<K, V> left, Node<K, V> right) {
            this.entry = entry;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public void add(Node<K, V> n) {
            if (left == null) {
                left = n;
            } else if (right == null) {
                right = n;
            } else {
                throw new IllegalStateException("This node has no empty slots: " + this);
            }
            n.setParent(this);
        }

        public boolean isRight(Node<K, V> child) {
            return right == child;
        }

        public boolean isLeft(Node<K ,V> child) {
            return left == child;
        }

        public void removeChild(Node<K, V> child) {
            if (isRight(child)) {
                right = null;
            } else if (isLeft(child)) {
                left = null;
            } else {
                throw new IllegalStateException("This node is not a child: " + child);
            }
            child.setParent(null);
        }

        public Entry<K, V> getEntry() {
            return entry;
        }

        public void setEntry(Entry<K, V> entry) {
            this.entry = entry;
        }

        public Node<K, V> getParent() {
            return parent;
        }

        public void setParent(Node<K, V> parent) {
            this.parent = parent;
        }

        public Node<K, V> getLeft() {
            return left;
        }

        public Node<K, V> getRight() {
            return right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public void swapEntries(Node<K, V> other) {
            Entry<K, V> otherEntry = other.getEntry();
            other.setEntry(this.getEntry());
            this.setEntry(otherEntry);
        }

        @Override
        public String toString() {
            return "Node{entry=" + entry + '}';
        }
    }

    private Node<K, V> root;
    private Node<K, V> last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> entry = new PQEntry<>(key, value);
        Node<K, V> node = new Node<>(entry);
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

    private Node<K, V> addNext(Node<K, V> next) {
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

    private Node<K, V> findParentForExtendingBottomRow(Node<K, V> node) {
        var parent = node.getParent();
        if (parent != null) {
            var superParent = parent.getParent();
            if (superParent != null) {
                return superParent.getRight();
            }
        }
        return null;
    }

    private Node<K, V> findLeftLeaf() {
        Node<K, V> n = root;
        while (n.getLeft() != null) {
            n = n.getLeft();
        }
        return n;
    }

    private void upHeap(Node<K, V> node) {
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
        Node<K, V> parentLast = last.getParent();
        Node<K, V> prev = findPrev(last);
        if (parentLast != null) {
            parentLast.removeChild(last);
        }
        last = prev;
        size--;
        downHeap(root);
        return minEntry;
    }

    private Node<K, V> findPrev(Node<K, V> node) {
        Node<K, V> p = node.getParent();
        if (p == null) {
            return null;
        } else if (p.isRight(node)) {
            return p.getLeft();
        } else if (p.isLeft(node)) {
            Node<K, V> rightSibling = findRightSibling(node);
            if (rightSibling != null) {
                return rightSibling;
            } else {
                return findMostRight(); // it works when last is the first in row only!!!
            }
        }
        return p;
    }

    private Node<K, V> findRightSibling(Node<K, V> node) {
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

    private Node<K, V> findMostRight() {
        Node<K, V> n = root;
        while (n.getRight() != null) {
            n = n.getRight();
        }
        return n;
    }

    private void downHeap(Node<K, V> node) {
        Node<K, V> target;
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
