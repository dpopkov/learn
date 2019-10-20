package learn.dsajg6e.ch10maps;


import learn.dsajg6e.ch09pq2.Entry;

import java.util.Iterator;

public abstract class AbstractMap<K, V> implements Map<K, V> {

    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }

        @Override
        public String toString() {
            return "{" + key + ":" + value + '}';
        }
    }

    /** This iterator is used in public {@link #keySet} method. */
    private class KeyIterator implements Iterator<K> {
        private final Iterator<Entry<K, V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class KeyIterable implements Iterable<K> {
        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    @Override
    public Iterable<K> keySet() {
        return new KeyIterable();   // todo: when the class is complete then substitute method-ref for this inner class
    }

    /** This iterator is used in public {@link @values} method. */
    private class ValueIterator implements Iterator<V> {
        private final Iterator<Entry<K, V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public V next() {
            return entries.next().getValue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class ValueIterable implements Iterable<V> {
        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    @Override
    public Iterable<V> values() {
//        return ValueIterator::new;
        return new ValueIterable(); // todo: when the class is complete then substitute method-ref above for the inner class.
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
