package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch09pq2.Entry;
import learn.dsajg6e.ch10maps.AbstractHashMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class P1067LinkedHashMap<K, V> extends AbstractHashMap<K, V> {
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    public static class LinkedMapEntry<K, V> extends MapEntry<K, V> {
        private LinkedMapEntry<K, V> prev;
        private LinkedMapEntry<K, V> next;

        public LinkedMapEntry(K key, V value) {
            super(key, value);
        }

        public LinkedMapEntry<K, V> getPrev() {
            return prev;
        }

        public void setPrev(LinkedMapEntry<K, V> prev) {
            this.prev = prev;
        }

        public LinkedMapEntry<K, V> getNext() {
            return next;
        }

        public void setNext(LinkedMapEntry<K, V> next) {
            this.next = next;
        }
    }

    private List<LinkedMapEntry<K, V>>[] table;
    private final LinkedMapEntry<K, V> headSentinel = new LinkedMapEntry<>(null, null);
    private final LinkedMapEntry<K, V> tailSentinel = new LinkedMapEntry<>(null, null);
    private LinkedMapEntry<K, V> last;
    {
        headSentinel.setNext(tailSentinel);
        tailSentinel.setPrev(headSentinel);
    }

    public P1067LinkedHashMap() {
    }

    public P1067LinkedHashMap(int capacity) {
        super(capacity, DEFAULT_LOAD_FACTOR);
    }

    /* This constructor should be used for testing purposes. */
    @SuppressWarnings("SameParameterValue")
    P1067LinkedHashMap(int capacity, double loadFactor, int prime, long scale, long shift) {
        super(capacity, loadFactor, prime, scale, shift);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void createTable(int capacity) {
        table = (List<LinkedMapEntry<K, V>>[]) new List[capacity];
    }

    @Override
    protected void resize(int newCapacity) {
        capacity = newCapacity;
        createTable(capacity);
        size = 0;
        for (Entry<K, V> e : entrySet()) {
            putToBucketInTable(hashValue(e.getKey()), (LinkedMapEntry<K, V>) e);
            ensureSizeWithinLoadFactor();
        }
    }

    private void putToBucketInTable(int hash, LinkedMapEntry<K, V> entry) {
        List<LinkedMapEntry<K, V>> bucket = table[hash];
        if (bucket == null) {
            bucket = new ArrayList<>();
            table[hash] = bucket;
        }
        bucket.add(entry);
        increaseSize(1);
    }

    @Override
    protected V bucketGet(int hash, K key) {
        List<LinkedMapEntry<K, V>> bucket = table[hash];
        if (bucket == null) {
            return null;
        }
        for (LinkedMapEntry<K, V> e : bucket) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }

    @Override
    protected boolean bucketContainsKey(int hash, K key) {
        List<LinkedMapEntry<K, V>> bucket = table[hash];
        if (bucket == null) {
            return false;
        }
        for (var e : bucket) {
            if (e.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected V bucketPut(int hash, K key, V value) {
        List<LinkedMapEntry<K, V>> bucket = table[hash];
        if (bucket == null) {
            bucket = new ArrayList<>();
            table[hash] = bucket;
        } else {
            for (LinkedMapEntry<K, V> e : bucket) {
                if (e.getKey().equals(key)) {
                    V oldValue = e.getValue();
                    e.setValue(value);
                    return oldValue;
                }
            }
        }
        LinkedMapEntry<K, V> newEntry = new LinkedMapEntry<>(key, value);
        bucket.add(newEntry);
        insertLinked(newEntry);
        increaseSize(1);
        return null;
    }

    private void insertLinked(LinkedMapEntry<K, V> entry) {
        if (last == null) {
            insertAfter(headSentinel, entry);
        } else {
            insertAfter(last, entry);
        }
        last = entry;
    }

    private void insertAfter(LinkedMapEntry<K, V> prev, LinkedMapEntry<K, V> entry) {
        prev.setNext(entry);
        tailSentinel.setPrev(entry);
        entry.setPrev(prev);
        entry.setNext(tailSentinel);
    }

    @Override
    protected V bucketPutIfAbsent(int hash, K key, V value) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    protected V bucketRemove(int hash, K key) {
        List<LinkedMapEntry<K, V>> bucket = table[hash];
        if (bucket == null) {
            return null;
        }
        for (int i = 0; i < bucket.size(); i++) {
            LinkedMapEntry<K, V> entry = bucket.get(i);
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                bucket.remove(i);
                removeLinked(entry);
                decreaseSize(1);
                return oldValue;
            }
        }
        return null;
    }

    private void removeLinked(LinkedMapEntry<K, V> entry) {
        LinkedMapEntry<K, V> prev = entry.getPrev();
        LinkedMapEntry<K, V> next = entry.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        entry.setNext(null);
        entry.setPrev(null);
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {
        private LinkedMapEntry<K, V> current = headSentinel;

        @Override
        public boolean hasNext() {
            return current.getNext() != tailSentinel;
        }

        @Override
        public Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current = current.getNext();
            return current;
        }
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return EntryIterator::new;
    }
}
