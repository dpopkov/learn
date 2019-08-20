package learn.dsajg6e.ch09priorityqueues;

public interface AdaptablePriorityQueue<K, V> extends PriorityQueue<K, V> {

    /** Removes entry e from the priority queue. */
    void remove(Entry<K, V> e);

    /** Replaces the key of existing entry e with k. */
    void replaceKey(Entry<K, V> e, K key);

    /** Replaces the value of existing entry e with v. */
    void replaceValue(Entry<K, V> e, V value);
}
