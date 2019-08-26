package learn.dsajg6e.ch09priorityqueues;

import java.util.Comparator;

/**
 * CF-9.5
 * A base class to assist implementations of the {@link PriorityQueue} interface.
 * @param <K> type of key
 * @param <V> type of value
 */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

    /** The comparator defining the ordering of keys in the priority queue. */
    private final Comparator<K> comparator;

    /** Creates an empty priority queue based on the natural ordering of its keys. */
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<>());
    }

    /** Creates an empty priority queue using the given comparator to order keys. */
    protected AbstractPriorityQueue(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    /** Method for comparing two entries according to key. */
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comparator.compare(a.getKey(), b.getKey());
    }

    /** Determines whether the key is valid. */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comparator.compare(key, key) == 0);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    /** Tests whether the priority queue is empty. */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
