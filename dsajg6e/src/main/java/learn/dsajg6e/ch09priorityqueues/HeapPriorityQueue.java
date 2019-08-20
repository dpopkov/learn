package learn.dsajg6e.ch09priorityqueues;

import learn.dsajg6e.ch07list.positional.PositionalList;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * CF-9.8
 * An implementation of a priority queue using an array-based heap.
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /** Primary collection of priority queue entries. */
    protected final ArrayList<Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
        super();
    }

    @SuppressWarnings("unused")
    public HeapPriorityQueue(Comparator<K> comparator) {
        super(comparator);
    }

    /** Creates a priority queue initialized with the given key-value pairs. */
    public HeapPriorityQueue(K[] keys, V[] values) {
        super();
        int length = Math.min(keys.length, values.length);
        for (int j = 0; j < length; j++) {
            heap.add(new PQEntry<>(keys[j], values[j]));
        }
        heapify();
    }

    /** Performs a bottom-up construction of the heap in linear time. */
    private void heapify() {
        int start = parent(heap.size() - 1);
        for (int j = start; j >= 0; j--) {
            downHeap(j);
        }
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> entry = new PQEntry<>(key, value);
        heap.add(entry);
        upHeap(heap.size() - 1);
        return entry;
    }

    /** Moves the entry at index j higher, if necessary, to restore the heap property. */
    protected void upHeap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) >= 0) {
                break;
            }
            swap(j, p);
            j = p;
        }
    }

    @Override
    public Entry<K, V> min() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, V> min = heap.get(0);
        int last = heap.size() - 1;
        swap(0, last);
        heap.remove(last);
        downHeap(0);
        return min;
    }

    /** Moves the entry at index j lower, if necessary, to restore the heap property. */
    @SuppressWarnings("SameParameterValue")
    protected void downHeap(int j) {
        while (hasLeft(j)) {
            int leftIdx = left(j);
            int smallChildIdx = leftIdx;
            if (hasRight(j)) {
                int rightIdx = right(j);
                if (compare(heap.get(leftIdx), heap.get(rightIdx)) > 0) {
                    smallChildIdx = rightIdx;
                }
            }
            if (compare(heap.get(j), heap.get(smallChildIdx)) <= 0) {
                break;
            }
            swap(j, smallChildIdx);
            j = smallChildIdx;
        }
    }

    /** Exchanges the entries at indices i and j of the array list. */
    protected void swap(int i, int j) {
        var tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    /** Sorts sequence s, using internal priority queue p to produce the order. */
    public static <E> void pqSort(PositionalList<E> s) {
        PriorityQueue<E, ?> p = new HeapPriorityQueue<>();
        int n = s.size();
        for (int j = 0; j < n; j++) {
            E element = s.remove(s.first());
            p.insert(element, null);
        }
        for (int j = 0; j < n; j++) {
            E element = p.removeMin().getKey();
            s.addLast(element);
        }
    }
}
