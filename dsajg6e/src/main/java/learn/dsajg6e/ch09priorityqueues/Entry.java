package learn.dsajg6e.ch09priorityqueues;

/** CF-9.1.
 * Interface for a key-value pair.
 * @param <K> type of key
 * @param <V> type of value
 */
public interface Entry<K, V> {
    K getKey();
    V getValue();
}
