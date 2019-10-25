package learn.dsajg6e.ch10maps;

import learn.dsajg6e.ch09pq2.DefaultComparator;
import learn.dsajg6e.ch09pq2.Entry;

import java.util.Comparator;

public abstract class AbstractSortedMap<K, V> extends AbstractMap<K, V> implements SortedMap<K, V> {
    /** The comparator defining the ordering of keys in the map. */
    private Comparator<K> comparator;

    public AbstractSortedMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public AbstractSortedMap() {
        this(new DefaultComparator<>());
    }

    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comparator.compare(a.getKey(), b.getKey());
    }

    protected int compare(K a, Entry<K, V> b) {
        return comparator.compare(a, b.getKey());
    }

    protected int compare(Entry<K, V> a, K b) {
        return comparator.compare(a.getKey(), b);
    }

    protected int compare(K a, K b) {
        return comparator.compare(a, b);
    }

    /** Determines whether the key is valid. */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comparator.compare(key, key) == 0);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key: " + key);
        }
    }
}
