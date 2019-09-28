package learn.dsajg6e.ch09pq2;

public interface AdaptablePriorityQueue<K, V> {
    /** Removes entry e from the priority queue. */
    Entry<K, V> remove(Entry<K, V> e);

    /** Replaces the key of existing entry e with the specified key. */
    void replaceKey(Entry<K, V> e, K key);

    /** Replaces the value of existing entry e with the specified value. */
    void replaceValue(Entry<K, V> e, V value);
}
