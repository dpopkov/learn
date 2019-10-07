package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch09pq2.Entry;

/**
 * C-9.31
 * Heap queue that uses a complete linked binary tree
 * and a reference to the last node of that tree.
 */
public class C0931LinkedBinaryHeapQueue<K, V> extends AbstractLinkedBinaryTreeHeapQueue<K, V> {

    private BNode<K, V> last;

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
        }
        last = node;
        size++;
        return null;
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
}
