package learn.dsajg6e.ch09priorityqueues;

/**
 * CF-9.2
 * Interface for the priority queue ADT.
 * In a more advanced adaptable priority queue the returned {@link Entry}
 * can be subsequently updated or removed.
 * @param <K> type of key
 * @param <V> type of value
 */
public interface PriorityQueue<K, V> {
    int size();
    boolean isEmpty();
    Entry<K, V> insert(K key, V value) throws IllegalArgumentException;
    Entry<K, V> min();
    Entry<K, V> removeMin();
}
