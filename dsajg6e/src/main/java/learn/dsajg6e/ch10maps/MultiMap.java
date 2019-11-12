package learn.dsajg6e.ch10maps;

public interface MultiMap<K, V> {
    /** Adds a new entry associating key with the value. */
    void put(K key, V value);
    /** Returns all values associated with the specified key. */
    Iterable<V> get(K key);
    /** Removes the key-value entry if it exists. */
    boolean remove(K key, V value);
    /** Removes the key and all the associated values. */
    Iterable<V> removeAll(K key);
    /** Returns the total number of entries. */
    int size();
    boolean isEmpty();
}
