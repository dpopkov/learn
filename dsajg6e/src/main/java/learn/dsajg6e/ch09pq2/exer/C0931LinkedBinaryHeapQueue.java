package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch09pq2.AbstractPriorityQueue;
import learn.dsajg6e.ch09pq2.Entry;

/**
 * C-9.31
 * Heap queue that uses a complete linked binary tree
 * and a reference to the last node of that tree.
 */
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
            BNode<K, V> parentOfNext = findParentForNext(last);
            parentOfNext.addChild(node);
            last = node;
            upHeap(last);
            /*if (size == 1) {
                root.setLeft(node);
                if (compare(root.getEntry(), entry) > 0) {
                    root.swapLeft();
                }
            } else if (size == 2) {
                root.setRight(node);
                if (compare(root.getEntry(), entry) > 0) {
                    root.swapRight();
                }
            }*/
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
        if (size == 1) {
            root = null;
            last = null;
        } else {
            swap(root, last);
            BNode<K, V> newLast = findPrevious(last);
            removeFromParent(last);
            last = newLast;
            downHeap(root);
        }
        size--;
        return entry;
    }

    private void upHeap(BNode<K, V> node) {
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

    private BNode<K, V> findParentForNext(BNode<K, V> last) {
        if (last.isLeftChild()) {
            return last.getParent();
        }
        BNode<K, V> parentForNext = findParentForNextOnSameRow(last);
        if (parentForNext != null) {
            return parentForNext;
        }
        return findMostLeft();
    }

    private BNode<K, V> findParentForNextOnSameRow(BNode<K, V> last) {
        int rows = 0;
        BNode<K, V> node = last;
        while (node.isRightChild()) {
            node = node.getParent();
            rows--;
        }
        // post condition: node has no parent (is root) OR node is left child
        if (node.getParent() == null) {
            return null;    // is was the last node in the row
        }
        node = node.getParent().getRight();
        while (rows != -1) {
            node = node.getLeft();
            rows++;
        }
        return node;
    }

    private BNode<K, V> findPrevious(BNode<K, V> node) {
        BNode<K, V> prev = findPreviousOnSameRow(node);
        if (prev != null) {
            return prev;
        }
        return findMostRight();
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

    private BNode<K, V> findMostLeft() {
        BNode<K, V> node = root;
        while (node.hasLeft()) {
            node = node.getLeft();
        }
        return node;
    }

    private BNode<K, V> findMostRight() {
        BNode<K, V> node = root;
        while (node.getRight() != null) {
            node = node.getRight();
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
