package learn.dsajg6e.ch09priorityqueues;

import learn.dsajg6e.ch07list.positional.LinkedPositionalList;
import learn.dsajg6e.ch07list.positional.Position;

import java.util.Comparator;

/**
 * CF-9.7
 * An implementation of a priority queue using a sorted list.
 */
public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /** Primary collection of priority queue sorted entries. */
    private final LinkedPositionalList<Entry<K, V>> sorted = new LinkedPositionalList<>();

    /** Creates an empty priority queue based on the natural ordering of its keys. */
    public SortedPriorityQueue() {
        super();
    }

    /** Creates an empty priority queue using the given comparator to order keys. */
    public SortedPriorityQueue(Comparator<K> comparator) {
        super(comparator);
    }

    @Override
    public int size() {
        return sorted.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        Position<Entry<K, V>> walk = sorted.last();
        while (walk != null && compare(newest, walk.getElement()) < 0) {
            walk = sorted.before(walk);
        }
        if (walk == null) {
            sorted.addFirst(newest);
        } else {
            sorted.addAfter(walk, newest);
        }
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if (sorted.isEmpty()) {
            return null;
        }
        return sorted.first().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        if (sorted.isEmpty()) {
            return null;
        }
        return sorted.remove(sorted.first());
    }
}
