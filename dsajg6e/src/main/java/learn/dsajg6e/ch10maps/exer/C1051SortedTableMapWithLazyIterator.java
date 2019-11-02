package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch09pq2.Entry;
import learn.dsajg6e.ch10maps.SortedTableMap;

import java.util.Iterator;

public class C1051SortedTableMapWithLazyIterator<K, V> extends SortedTableMap<K, V> {
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        Iterator<MapEntry<K, V>> iterator = super.getTable().iterator();
        Iterator<Entry<K, V>> entryIterator = new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Entry<K, V> next() {
                return iterator.next();
            }
        };
        return () -> entryIterator;
    }
}
