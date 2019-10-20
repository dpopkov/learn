package learn.dsajg6e.ch10maps;

import learn.dsajg6e.ch09pq2.Entry;

public interface Map<K, V> {
    /** Returns the number of entries in the map. */
    int size();

    /** Returns a boolean indicating whether the map is empty. */
    boolean isEmpty();

    /**
     * Returns the value associated with the key, is such an entry exists;
     * otherwise returns null.
     */
    V get(K key);

    /**
     * If the map does not have an entry with the key, then adds entry to the map and
     * returns null;
     * else, replaces with the specified value the existing value of the entry
     * with the specified key and returns the old value.
     */
    V put(K key, V value);

    /** Removes from the map the entry with the specified key, and returns its value;
     * if the map has no such entry, then returns null. */
    V remove(K key);

    /** Returns an iterable collection containing all the keys stored in the map. */
    Iterable<K> keySet();

    /** Returns an iterable collection containing all the values of entries stored in the map. */
    Iterable<V> values();

    /** Returns an iterable collection containing all the key-value entries stored in the map. */
    Iterable<Entry<K, V>> entrySet();
}
