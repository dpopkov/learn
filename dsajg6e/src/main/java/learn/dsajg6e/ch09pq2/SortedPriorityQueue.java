package learn.dsajg6e.ch09pq2;

import learn.dsajg6e.ch07list.positional.LinkedPositionalList;
import learn.dsajg6e.ch07list.positional.Position;

import java.util.Comparator;

public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /** Primary collection of priority queue entries. */
    private LinkedPositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

    public SortedPriorityQueue() {
        super();
    }

    public SortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        Position<Entry<K, V>> p = list.last();
        while (p != null && compare(p.getElement(), newest) > 0) {
            p = list.before(p);
        }
        if (p == null) {
            list.addFirst(newest);
        } else {
            list.addAfter(p, newest);
        }
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if (list.isEmpty()) {
            return null;
        }
        return list.first().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(list.first());
    }

    @Override
    public int size() {
        return list.size();
    }
}
