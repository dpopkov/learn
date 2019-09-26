package learn.dsajg6e.ch09pq2;

import learn.dsajg6e.ch07list.ArrayList;
import learn.dsajg6e.ch07list.positional.PositionalList;

import java.util.Comparator;

/**
 * An implementation of a priority queue using an array-based heap.
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /** Primary collection of priority queue entries. */
    protected final ArrayList<Entry<K, V>> heap = new ArrayList<>();

    /** Creates an empty priority queue based on the natural ordering of its keys. */
    public HeapPriorityQueue() {
        super();
    }

    /** Creates an empty priority queue using the given comparator to order keys. */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /** Creates a priority queue initialized with the given key-value pairs. */
    public HeapPriorityQueue(K[] keys, V[] values) {
        super();
        int n = Math.min(keys.length, values.length);
        for (int i = 0; i < n; i++) {
            heap.add(new PQEntry<>(keys[i], values[i]));
        }
        heapify();
    }

    /** Inserts a key/value pair and returns the entry created. */
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> entry = new PQEntry<>(key, value);
        heap.add(entry);
        upHeap(heap.size() - 1);
        return entry;
    }

    /** Returns (but does not remove) an entry with minimal key (if any). */
    @Override
    public Entry<K, V> min() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    /** Removes and returns an entry with minimal key (if any). */
    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        Entry<K, V> entry =heap.get(0);
        int last = heap.size() - 1;
        swap(0, last);
        heap.remove(last);
        downHeap(0);
        return entry;
    }

    /** Returns the number of items in the priority queue. */
    @Override
    public int size() {
        return heap.size();
    }

    /** Sorts sequence, using initially empty priority queue to produce the order. */
    public static <E> void pqSort(PositionalList<E> sequence, PriorityQueue<E, ?> priorityQueue) {
        int n = sequence.size();
        for (int j = 0; j < n; j++) {
            E element = sequence.remove(sequence.first());
            priorityQueue.insert(element, null);
        }
        for (int j = 0; j < n; j++) {
            E element = priorityQueue.removeMin().getKey();
            sequence.addLast(element);
        }
    }

    /* Protected utilities */
    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return j * 2 + 1;
    }

    protected int right(int j) {
        return j * 2 + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    /** Exchanges the entries at indices i and j of the array list. */
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /** Moves the entry at index j higher, if necessary, to restore the heap property. */
    protected void upHeap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) >= 0) {
                break;
            }
            swap(p, j);
            j = p;
        }
    }

    /** Moves the entry at index j lower, if necessary, to restore the heap property. */
    protected void downHeap(int j) {
        while (hasLeft(j)) {
            int leftIdx = left(j);
            int smallIdx = leftIdx;
            if (hasRight(j)) {
                int rightIdx = right(j);
                if (compare(heap.get(leftIdx), heap.get(rightIdx)) > 0) {
                    smallIdx = rightIdx;
                }
            }
            if (compare(heap.get(j), heap.get(smallIdx)) <= 0) {
                break;
            }
            swap(j, smallIdx);
            j = smallIdx;
        }
    }

    /** Performs a bottom-up construction of the heap in linear time. */
    protected void heapify() {
        int start = parent(size() - 1);
        for (int j = start; j >= 0; j--) {
            downHeap(j);
        }
    }
}
