package learn.dsajg6e.ch10maps;

import learn.dsajg6e.ch09pq2.Entry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * CF-10.4,10.5.
 * Implementation of a map using an array list as an unsorted table.
 */
public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    /** Underlying storage for the map of entries. */
    private final ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    @Override
    public int size() {
        return table.size();
    }

    /** Returns the value associated with the key, is such an entry exists;
        otherwise returns null. */
    @Override
    public V get(K key) {
        int idx = findIndex(key);
        if (idx == -1) {
            return null;
        }
        return table.get(idx).getValue();
    }

    /* R-10.3 */
    /** Checks whether the map contains the specified key. */
    public boolean containsKey(K key) {
        return findIndex(key) != -1;
    }

    /**
     * If the map does not have an entry with the key, then adds entry to the map and
     * returns null;
     * else, replaces with the specified value the existing value of the entry
     * with the specified key and returns the old value.
     */
    @Override
    public V put(K key, V value) {
        int idx = findIndex(key);
        if (idx == -1) {
            table.add(new MapEntry<>(key, value));
            return null;
        } else {
            return table.get(idx).setValue(value);
        }
    }

    /* C-10.33 */
    /**
     * Adds a new entry only if the map does not have an entry with the specified key
     * and returns null,
     * else returns the current value.
     */
    public V putIfAbsent(K key, V value) {
        int idx = findIndex(key);
        if (idx == -1) {
            table.add(new MapEntry<>(key, value));
            return null;
        } else {
            return table.get(idx).getValue();
        }
    }

    /** Removes from the map the entry with the specified key, and returns its value;
     * if the map has no such entry, then returns null. */
    @Override
    public V remove(K key) {
        int idx = findIndex(key);
        if (idx == -1) {
            return null;
        }
        V answer = table.get(idx).getValue();
        int last = table.size() - 1;
        if (idx != last) {
            table.set(idx, table.get(last));
        }
        table.remove(last);
        return answer;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return EntryIterator::new;
    }

    /** This iterator is used in public {@link #entrySet()} method. */
    private class EntryIterator implements Iterator<Entry<K, V>> {

        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < table.size();
        }

        @Override
        public Entry<K, V> next() {
            if (index == table.size()) {
                throw new NoSuchElementException();
            }
            return table.get(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /** Returns the index of an entry with the key that is equal to the specified key, or -1 if none found. */
    private int findIndex(K key) {
        int n = table.size();
        for (int i = 0; i < n; i++) {
            if (key.equals(table.get(i).getKey())) {
                return i;
            }
        }
        return -1;
    }
}
