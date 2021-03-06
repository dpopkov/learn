package learn.dsajg6e.ch10maps;


import learn.dsajg6e.ch09pq2.Entry;

import java.util.Iterator;
import java.util.Objects;

public abstract class AbstractMap<K, V> implements Map<K, V> {

    public static class MapEntry<K, V> implements Entry<K, V> {
        private final K key;
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

        /** Sets the specified value and returns the old value. */
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }

        @Override
        public String toString() {
            return "{" + key + ":" + value + '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) obj;
            return key.equals(mapEntry.key) && value.equals(mapEntry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    /** This iterator is used in public {@link #keySet()} method. */
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

    @Override
    public Iterable<K> keySet() {
        return KeyIterator::new;
    }

    /** This iterator is used in public {@link @values()} method. */
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

    @Override
    public Iterable<V> values() {
        return ValueIterator::new;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
