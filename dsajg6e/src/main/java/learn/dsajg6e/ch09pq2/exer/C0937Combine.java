package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.BinaryTree;
import learn.dsajg6e.ch09pq2.HeapPriorityQueue;
import learn.dsajg6e.ch09pq2.PriorityQueue;

/**
 * C-9.37
 */
@SuppressWarnings("unused")
public class C0937Combine<K extends Comparable<K>> {
    public PriorityQueue<K, Void> combine(BinaryTree<K> tree1, BinaryTree<K> tree2) {
        PriorityQueue<K, Void> queue1 = toPriorityQueue(tree1);
        PriorityQueue<K, Void> queue2 = toPriorityQueue(tree2);
        HeapPriorityQueue<K, Void> tree = new HeapPriorityQueue<>();
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            K key1 = queue1.removeMin().getKey();
            K key2 = queue2.removeMin().getKey();
            if (key1.compareTo(key2) < 0) {
                tree.insert(key1, null);
                tree.insert(key2, null);
            } else {
                tree.insert(key2, null);
                tree.insert(key1, null);
            }
        }
        while (!queue1.isEmpty()) {
            K key1 = queue1.removeMin().getKey();
            tree.insert(key1, null);
        }
        while (!queue2.isEmpty()) {
            K key2 = queue2.removeMin().getKey();
            tree.insert(key2, null);
        }
        return tree;
    }

    /**
     * Translates the tree that satisfies the heap-order property to priority queue.
     */
    private PriorityQueue<K, Void> toPriorityQueue(BinaryTree<K> tree) {
        PriorityQueue<K, Void> pQueue = new HeapPriorityQueue<>();
        for (Position<K> p : tree.positions()) {
            pQueue.insert(p.getElement(), null);
        }
        return pQueue;
    }
}
