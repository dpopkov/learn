package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch09pq2.AbstractPriorityQueue;
import learn.dsajg6e.ch09pq2.Entry;

public abstract class AbstractLinkedBinaryTreeHeapQueue<K, V> extends AbstractPriorityQueue<K, V> {
    protected static class BNode<K, V> {
        private Entry<K, V> entry;
        private BNode<K, V> parent;
        private BNode<K, V> left;
        private BNode<K, V> right;

        public BNode(Entry<K, V> entry) {
            this.entry = entry;
        }

        public Entry<K, V> getEntry() {
            return entry;
        }

        public void setEntry(Entry<K, V> entry) {
            this.entry = entry;
        }

        public BNode<K, V> getParent() {
            return parent;
        }

        public void setParent(BNode<K, V> parent) {
            this.parent = parent;
        }

        public BNode<K, V> getLeft() {
            return left;
        }

        public void setLeft(BNode<K, V> left) {
            this.left = left;
            left.setParent(this);
        }

        public void removeLeft() {
            left = null;
        }

        public BNode<K, V> getRight() {
            return right;
        }

        public void setRight(BNode<K, V> right) {
            this.right = right;
            right.setParent(this);
        }

        public void removeRight() {
            right = null;
        }

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
        }

        public boolean isLeftChild() {
            var p = getParent();
            return p != null && p.getLeft() == this;
        }

        public boolean isRightChild() {
            var p = getParent();
            return p != null && p.getRight() == this;
        }

        public void addChild(BNode<K, V> child) {
            if (!hasLeft()) {
                setLeft(child);
            } else if (!hasRight()) {
                setRight(child);
            } else {
                throw new IllegalStateException("Cannot add child because has 2 already");
            }
        }

        @Override
        public String toString() {
            return "BNode{entry=" + entry + '}';
        }
    }

    protected BNode<K, V> root;
    protected int size;

    @Override
    public Entry<K, V> min() {
        if (isEmpty()) {
            return null;
        }
        return root.getEntry();
    }

    @Override
    public int size() {
        return size;
    }

    protected void upHeap(BNode<K, V> node) {
        while (node.getParent() != null) {
            var p = node.getParent();
            if (compare(p.getEntry(), node.getEntry()) <= 0) {
                break;
            }
            swap(p, node);
            node = p;
        }
    }

    protected void downHeap(BNode<K, V> node) {
        while (node.hasLeft()) {
            var smallest = node.getLeft();
            if (node.hasRight()) {
                var right = node.getRight();
                if (compare(smallest.getEntry(), right.getEntry()) > 0) {
                    smallest = right;
                }
            }
            if (compare(node.getEntry(), smallest.getEntry()) <= 0) {
                break;
            }
            swap(node, smallest);
            node = smallest;
        }
    }

    protected void swap(BNode<K, V> a, BNode<K, V> b) {
        Entry<K, V> tmp = a.getEntry();
        a.setEntry(b.getEntry());
        b.setEntry(tmp);
    }

    protected BNode<K, V> findMostLeft() {
        BNode<K, V> node = root;
        while (node.hasLeft()) {
            node = node.getLeft();
        }
        return node;
    }

    protected BNode<K, V> findMostRight() {
        BNode<K, V> node = root;
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    protected void removeFromParent(BNode<K, V> node) {
        if (node.hasLeft() || node.hasRight()) {
            throw new IllegalStateException("Can not remove: this node has children");
        }
        var p = node.getParent();
        if (p == null) {
            throw new IllegalStateException("Can not remove from parent: parent is null");
        } else if (node == p.getRight()) {
            p.removeRight();
        } else if (node == p.getLeft()) {
            p.removeLeft();
        } else {
            throw new IllegalStateException("This node is not a child of its parent");
        }
    }

}
