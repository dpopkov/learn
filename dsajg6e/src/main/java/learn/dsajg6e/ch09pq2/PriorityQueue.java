package learn.dsajg6e.ch09pq2;

public interface PriorityQueue<K, V> {
    /**
     * Creates an entry with key k and value v in the priority queue.
     */
    Entry<K, V> insert(K key, V value) throws IllegalArgumentException;
    /**
     * Returns (but does not remove) a priority queue entry having minimal key;
     * returns null if the priority queue is empty.
     */
    Entry<K, V> min();
    /**
     * Removes and returns an entry having minimal key from the priority queue;
     * returns null if the priority queue is empty.
     */
    Entry<K, V> removeMin();
    /**
     * Returns the number of entries in the priority queue.
     */
    int size();
    /**
     * Returns a boolean indicating whether the priority queue is empty.
     */
    boolean isEmpty();
}
