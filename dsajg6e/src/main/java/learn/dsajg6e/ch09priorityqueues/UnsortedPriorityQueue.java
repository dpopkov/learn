package learn.dsajg6e.ch09priorityqueues;

import learn.dsajg6e.ch07list.positional.LinkedPositionalList;
import learn.dsajg6e.ch07list.positional.Position;

import java.util.Comparator;

/**
 * CF-9.6
 * An implementation of a priority queue using an unsorted list.
 */
public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /** Primary collection of priority queue entries. */
    private LinkedPositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

    /** Creates an empty priority queue based on the natural ordering of its keys. */
    public UnsortedPriorityQueue() {
        super();
    }

    /** Creates an empty priority queue using the given comparator to order keys. */
    public UnsortedPriorityQueue(Comparator<K> comparator) {
        super(comparator);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        list.addLast(newest);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if (list.isEmpty()) {
            return null;
        }
        return findMin().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(findMin());
    }

    /** Finds the position of an entry having minimal key. */
    private Position<Entry<K, V>> findMin() {
        Position<Entry<K, V>> small = list.first();
        for (Position<Entry<K, V>> walk : list.positions()) {
            if (compare(walk.getElement(), small.getElement()) < 0) {
                small = walk;
            }
        }
        return small;
    }
}
