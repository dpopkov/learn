package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch09pq2.AbstractPriorityQueue;
import learn.dsajg6e.ch09pq2.Entry;

public class C0931LinkedBinaryHeapQueue<K, V> extends AbstractPriorityQueue<K, V> {

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

        public void swapLeft() {
            Entry<K, V> tmp = left.getEntry();
            left.setEntry(getEntry());
            setEntry(tmp);
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

        public void removeLast() {
            if (right != null) {
                right = null;
            } else if (left != null) {
                left = null;
            }
        }

        public void swapRight() {
            Entry<K, V> tmp = right.getEntry();
            right.setEntry(getEntry());
            setEntry(tmp);
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

        @Override
        public String toString() {
            return "BNode{entry=" + entry + '}';
        }
    }

    private BNode<K, V> root;
    private BNode<K, V> last;
    private int size;

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        PQEntry<K, V> entry = new PQEntry<>(key, value);
        BNode<K, V> node = new BNode<>(entry);
        if (root == null) {
            root = node;
        } else {
            if (size == 1) {
                root.setLeft(node);
                if (compare(root.getEntry(), entry) > 0) {
                    root.swapLeft();
                }
            } else if (size == 2) {
                root.setRight(node);
                if (compare(root.getEntry(), entry) > 0) {
                    root.swapRight();
                }
            }
        }
        last = node;
        size++;
        return null;
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
        if (isEmpty()) {
            return null;
        }
        Entry<K, V> entry = root.getEntry();
        if (size() == 1) {
            root = null;
            last = null;
        } else {
            swap(root, last);
            BNode<K, V> newLast = previous(last);
            removeFromParent(last);
            last = newLast;
            downHeap(root);
        }
        size--;
        return entry;
    }

    private BNode<K, V> previous(BNode<K, V> node) {
        /*var p = node.getParent();
        if (p.getRight() == node) {
            return p.getLeft();
        }*/
        BNode<K, V> prev = findPreviousOnSameRow(node);


        // 2. If this node is last on the row, then find the most right on the upper row
        // todo: implement this case

        return prev;
    }

    private BNode<K, V> findPreviousOnSameRow(BNode<K, V> node) {
        if (node.isRightChild()) {
            return node.getParent().getLeft();
        }
        int rows = 0;
        // Go Up the Heap
        while (node.isLeftChild()) {
            node = node.getParent();
            rows--;
        }
        // post condition: node has no parent (came to root)  OR  node.isRightChild()
        if (node.getParent() == null) { // came to parent through the left side
            return null;
        }
        // post condition: node is right child
        node = node.getParent().getLeft();
        // Go Down
        while (rows != 0) {
            node = node.getRight();
            rows++;
        }
        return node;
    }

    private void removeFromParent(BNode<K, V> node) {
        if (node.hasLeft() || node.hasRight()) {
            throw new IllegalStateException("Node has children");
        }
        var p = node.getParent();
        if (node == p.getRight()) {
            p.removeRight();
        } else if (node == p.getLeft()) {
            p.removeLeft();
        } else {
            throw new IllegalStateException("This node is not a child of its parent");
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

    @Override
    public int size() {
        return size;
    }
}
