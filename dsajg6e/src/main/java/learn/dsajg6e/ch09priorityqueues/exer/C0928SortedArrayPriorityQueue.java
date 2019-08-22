package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch09priorityqueues.AbstractPriorityQueue;
import learn.dsajg6e.ch09priorityqueues.Entry;

/** Re-implementation of the SortedPriorityQueue using a Java array. */
public class C0928SortedArrayPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    private final PQEntry<K, V>[] entries;
    private int size;

    @SuppressWarnings("unchecked")
    public C0928SortedArrayPriorityQueue(int capacity) {
        entries = (PQEntry<K, V>[]) new PQEntry[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        if (size == entries.length) {
            throw new IllegalStateException("Queue is full");
        }
        checkKey(key);
        PQEntry<K, V> e = new PQEntry<>(key, value);
        int j = size;
        while (j > 0 && compare(entries[j - 1], e) < 0) {
            entries[j] = entries[j - 1];
            j--;
        }
        entries[j] = e;
        size++;
        return e;
    }

    @Override
    public Entry<K, V> min() {
        return entries[size - 1];
    }

    @Override
    public Entry<K, V> removeMin() {
        int last = --size;
        PQEntry<K, V> entry = entries[last];
        entries[last] = null;
        return entry;
    }
}
