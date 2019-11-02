package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch09pq2.Entry;
import learn.dsajg6e.ch10maps.ChainHashMap;
import learn.dsajg6e.ch10maps.UnsortedTableMap;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class C1052ChainHashMapWithLazyIterator<K, V> extends ChainHashMap<K, V> {
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        final UnsortedTableMap<K, V>[] table = super.getTable();

        Iterator<Entry<K, V>> iterator = new Iterator<>() {
            private int bucketIdx = 0;
            private Iterator<Entry<K, V>> bucketIterator;

            @Override
            public boolean hasNext() {
                if (bucketIdx >= table.length) {
                    return false;
                }
                if (bucketIterator != null && bucketIterator.hasNext()) {
                    return true;
                }
                bucketIterator = findNextBucketIterator();
                return bucketIterator != null && bucketIterator.hasNext();
            }

            @Override
            public Entry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return bucketIterator.next();
            }

            private Iterator<Entry<K, V>> findNextBucketIterator() {
                bucketIdx++;
                for (; bucketIdx < table.length; bucketIdx++) {
                    if (table[bucketIdx] != null) {
                        return table[bucketIdx].entrySet().iterator();
                    }
                }
                return null;
            }
        };
        return () -> iterator;
    }
}
