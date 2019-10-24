package learn.dsajg6e.ch10maps;

import learn.dsajg6e.ch09pq2.Entry;

import java.util.ArrayList;

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    /** A fixed capacity array that serves as buckets. */
    private UnsortedTableMap<K, V>[] table;

    public ChainHashMap() {
        super();
    }

    public ChainHashMap(int capacity) {
        super(capacity);
    }

    public ChainHashMap(int capacity, int prime) {
        super(capacity, prime);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void createTable() {
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    /**
     * Returns value associated with the key in bucket with the specified hash value,
     * or else null.
     */
    @Override
    protected V bucketGet(int hash, K key) {
        UnsortedTableMap<K, V> bucket = table[hash];
        if (bucket == null) {
            return null;
        }
        return bucket.get(key);
    }

    @Override
    protected V bucketPut(int hash, K key, V value) {
        UnsortedTableMap<K, V> bucket = table[hash];
        if (bucket == null) {
            bucket = table[hash] = new UnsortedTableMap<>();
        }
        int oldSize = bucket.size();
        V answer = bucket.put(key, value);
        increaseSize(bucket.size() - oldSize);
        return answer;
    }

    @Override
    protected V bucketRemove(int hash, K key) {
        UnsortedTableMap<K, V> bucket = table[hash];
        if (bucket == null) {
            return null;
        }
        int oldSize = bucket.size();
        V answer = bucket.remove(key);
        decreaseSize(oldSize - bucket.size());
        return answer;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++) {
            if (table[h] != null) {
                for (Entry<K, V> entry : table[h].entrySet()) {
                    buffer.add(entry);
                }
            }
        }
        return buffer;
    }
}
