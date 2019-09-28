package learn.dsajg6e.ch09pq2;

import java.util.Comparator;

public class HeapAdaptablePriorityQueue<K, V> extends HeapPriorityQueue<K, V> implements AdaptablePriorityQueue<K, V> {

    /** Extension of the {@link PQEntry} to include location information. */
    protected static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {
        /** Entry's current index within the heap. */
        private int index;

        public AdaptablePQEntry(K key, V value, int index) {
            super(key, value);
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    /** Creates an empty adaptable priority queue using natural ordering of keys. */
    public HeapAdaptablePriorityQueue() {
        super();
    }

    /** Creates an empty adaptable priority queue using the given comparator. */
    @SuppressWarnings("unused")
    public HeapAdaptablePriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /** Inserts a key-value pair and returns the entry created. */
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new AdaptablePQEntry<>(key, value, heap.size());
        heap.add(newest);
        upHeap(heap.size() - 1);
        return newest;
    }

    /** Removes the given entry from the priority queue. */
    @Override
    public Entry<K, V> remove(Entry<K, V> e) {
        AdaptablePQEntry<K, V> locator = validate(e);
        int j = locator.getIndex();
        if (j == heap.size() - 1) {
            heap.remove(heap.size() - 1);
        } else {
            swap(j, heap.size() - 1);
            heap.remove(heap.size() - 1);
            bubble(j);
        }
        return locator;
    }

    @Override
    public void replaceKey(Entry<K, V> e, K key) {
        AdaptablePQEntry<K, V> locator = validate(e);
        checkKey(key);
        locator.setKey(key);
        bubble(locator.getIndex());
    }

    @Override
    public void replaceValue(Entry<K, V> e, V value) {
        AdaptablePQEntry<K, V> locator = validate(e);
        locator.setValue(value);
    }

    /* Protected utilities */

    /** Validates an entry to ensure it is location-aware. */
    @SuppressWarnings("DuplicatedCode")
    protected AdaptablePQEntry<K, V> validate(Entry<K, V> entry) throws IllegalArgumentException {
        if (!(entry instanceof AdaptablePQEntry)) {
            throw new IllegalArgumentException("Invalid entry");
        }
        AdaptablePQEntry<K, V> locator = (AdaptablePQEntry<K, V>) entry;
        int j = locator.getIndex();
        if (j >= heap.size() || heap.get(j) != locator) {
            throw new IllegalArgumentException("Invalid entry");
        }
        return locator;
    }

    /** Exchanges the entries at indices i and j of the array list. */
    @Override
    protected void swap(int i, int j) {
        super.swap(i, j);
        ((AdaptablePQEntry<K, V>) heap.get(i)).setIndex(i);
        ((AdaptablePQEntry<K, V>) heap.get(j)).setIndex(j);
    }

    /** Restores the heap property by moving the entry at index j upward/downward. */
    protected void bubble(int j) {
        if (j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0) {
            upHeap(j);
        } else {
            downHeap(j);
        }
    }
}
