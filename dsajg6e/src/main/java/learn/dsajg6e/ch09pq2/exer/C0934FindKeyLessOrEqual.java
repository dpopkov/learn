package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch06stacks.LinkedQueue;
import learn.dsajg6e.ch06stacks.Queue;
import learn.dsajg6e.ch09pq2.Entry;
import learn.dsajg6e.ch09pq2.HeapPriorityQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * C-9.34
 * Algorithm to compute all the entries in the heap having a key less than or equal to
 * the specified key.
 */
public class C0934FindKeyLessOrEqual<K, V> extends HeapPriorityQueue<K, V> {
    public List<K> keysLessOrEqualTo(K key) {
        if (isEmpty()) {
            return List.of();
        }
        List<K> list = new ArrayList<>();
        final Entry<K, V> keyEntry = new PQEntry<>(key, null);
        int idx = 0;
        Entry<K, V> e = heap.get(idx);
        Queue<Integer> indexes = new LinkedQueue<>();
        if (compare(e, keyEntry) <= 0) {
            list.add(e.getKey());
            indexes.enqueue(idx);
            while (!indexes.isEmpty()) {
                idx = indexes.dequeue();
                int leftIdx = left(idx);
                Entry<K, V> leftChild = heap.get(leftIdx);
                if (compare(leftChild, keyEntry) <= 0) {
                    list.add(leftChild.getKey());
                    indexes.enqueue(leftIdx);
                }
                int rightIdx = right(idx);
                Entry<K, V> rightChild = heap.get(rightIdx);
                if (compare(rightChild, keyEntry) <= 0) {
                    list.add(rightChild.getKey());
                    indexes.enqueue(rightIdx);
                }
            }
        }
        return list;
    }
}
