package learn.dsajg6e.ch09pq2;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
    protected static class PQEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public PQEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        protected void setKey(K key) {
            this.key = key;
        }

        protected void setValue(V value) {
            this.value = value;
        }
    }

    /** The comparator defining the ordering of keys in the priority queue. */
    private Comparator<K> comp;

    /** Creates an empty priority queue using the given comparator to order keys. */
    public AbstractPriorityQueue(Comparator<K> comp) {
        this.comp = comp;
    }
    /** Creates an empty priority queue based on the natural ordering of its keys. */
    public AbstractPriorityQueue() {
        this(new DefaultComparator<>());
    }

    /** Compares two entries according to key. */
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /** Determines whether a key is valid. */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return comp.compare(key, key) == 0;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible keys");
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
