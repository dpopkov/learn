package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch09pq2.AbstractPriorityQueue;
import learn.dsajg6e.ch09pq2.Entry;

/**
 * C-9.28
 * Sorted priority queue using an array. Method {@link #removeMin} has O(1) performance.
 */
public class C0928SortedArrayPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    private Entry<K, V>[] heap;
    private int size;

    @SuppressWarnings("unchecked")
    public C0928SortedArrayPriorityQueue(int capacity) {
        heap = (Entry<K, V>[]) new Entry[capacity];
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        if (size == heap.length) {
            throw new IllegalStateException("Queue is full");
        }
        Entry<K, V> entry = new PQEntry<>(key, value);
        int j = size;
        while (j > 0 && compare(entry, heap[j - 1]) > 0) {
            heap[j] = heap[j - 1];
            j--;
        }
        heap[j] = entry;
        size++;
        return entry;
    }

    @Override
    public Entry<K, V> min() {
        if (isEmpty()) {
            return null;
        }
        return heap[size - 1];
    }

    @Override
    public Entry<K, V> removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, V> entry = heap[--size];
        heap[size] = null;
        return entry;
    }

    @Override
    public int size() {
        return size;
    }

    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return j * 2 + 1;
    }

    protected int right(int j) {
        return j * 2 + 2;
    }
}
