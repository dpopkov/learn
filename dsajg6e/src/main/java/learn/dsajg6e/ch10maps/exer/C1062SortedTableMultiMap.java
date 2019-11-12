package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch10maps.MultiMap;

import java.util.ArrayList;
import java.util.List;

/**
C-10.62
Multi-map that is implemented using a sorted search table that includes duplicates.
 */
public class C1062SortedTableMultiMap<K extends Comparable<K>, V> implements MultiMap<K, V> {
    private static class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public int compareTo(Entry<K, V> other) {
            return key.compareTo(other.getKey());
        }
    }

    private final Entry<K, V>[] entries;
    private int size;

    @SuppressWarnings("unchecked")
    public C1062SortedTableMultiMap(int capacity) {
        entries = (Entry<K, V>[]) new Entry[capacity];
    }

    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return a.compareTo(b);
    }

    @Override
    public void put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        int i = size;
        for (; i > 0 && entries[i - 1].compareTo(newEntry) > 0; i--) {
            entries[i] = entries[i - 1];
        }
        entries[i] = newEntry;
        size++;
    }

    @Override
    public Iterable<V> get(K key) {
        List<V> values = new ArrayList<>();
        int i = findIndex(key);
        if (i == -1) {
            return null;
        }
        while (i > 0 && entries[i - 1].getKey().equals(key)) {
            i--;
        }
        while (i < size && entries[i].getKey().equals(key)) {
            values.add(entries[i].getValue());
            i++;
        }
        return values;
    }

    @Override
    public boolean remove(K key, V value) {
        int i = findIndex(key, value);
        if (i == -1) {
            return false;
        }
        System.arraycopy(entries, i + 1, entries, i, size - i - 1);
        size--;
        return true;
    }

    private int findIndex(K key) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = entries[mid].getKey().compareTo(key);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    protected int findIndex(K key, V value) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Entry<K, V> entry = entries[mid];
            if (entry.getKey().equals(key) && entry.getValue().equals(value)) {
                return mid;
            }
            if (entry.getKey().compareTo(key) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    @Override
    public Iterable<V> removeAll(K key) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
