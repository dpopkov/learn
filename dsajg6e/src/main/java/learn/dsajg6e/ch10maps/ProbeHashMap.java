package learn.dsajg6e.ch10maps;

import learn.dsajg6e.ch09pq2.Entry;

import java.util.ArrayList;

/**
 * CF-10.9
 * Implements linear probing for collision resolution.
 */
public class ProbeHashMap<K, V> extends AbstractHashMap<K, V> {
    /** A special marker that is placed in a table location at which an entry has been deleted,
        so that we can distinguish between it and a location that has always been empty. */
    private final MapEntry<K, V> DEFUNCT = new MapEntry<>(null, null);

    private MapEntry<K, V>[] table;

    public ProbeHashMap() {
        super();
    }

    public ProbeHashMap(int capacity) {
        super(capacity);
    }

    public ProbeHashMap(int capacity ,int prime) {
        super(capacity, prime);
    }

    /** Creates an empty table having length equal to current capacity. */
    @SuppressWarnings("unchecked")
    @Override
    protected void createTable() {
        table = (MapEntry<K, V>[]) new MapEntry[capacity];
    }

    /** Returns true if location is either empty or the "defunct" sentinel. */
    private boolean isAvailable(int j) {
        return table[j] == null || table[j] == DEFUNCT;
    }

    /** Returns index with the key, or -(a + 1) such that the key could be added at index a. */
    private int findSlot(int hash, K key) {
        int avail = -1;
        int j = hash;
        do {
            if (isAvailable(j)) {
                if (avail == -1) {
                    avail = j;
                }
                if (table[j] == null) {
                    break;
                }
            } else if (table[j].getKey().equals(key)) {
                return j;
            }
            j = (j + 1) % capacity;
        } while (j != hash);
        return -(avail + 1);
    }

    /** Returns value associated with the key in bucket with the hash value, or else null. */
    @Override
    protected V bucketGet(int hash, K key) {
        int j = findSlot(hash, key);
        if (j < 0) {
            return null;
        }
        return table[j].getValue();
    }

    /* C-10.36 */
    @Override
    protected boolean bucketContainsKey(int hash, K key) {
        int j = findSlot(hash, key);
        return j >= 0;
    }

    /** Associates the key with the value in bucket with the specified hash; returns old value. */
    @Override
    protected V bucketPut(int hash, K key, V value) {
        int j = findSlot(hash, key);
        if (j < 0) {
            table[-j - 1] = new MapEntry<>(key, value);
            increaseSize(1);
            return null;
        }
        return table[j].setValue(value);
    }

    /* C-10.35 */
    @Override
    protected V bucketPutIfAbsent(int hash, K key, V value) {
        int j = findSlot(hash, key);
        if (j < 0) {
            table[-j - 1] = new MapEntry<>(key, value);
            increaseSize(1);
            return null;
        }
        return table[j].getValue();
    }

    /** Removes entry having the key from bucket with the hash value (if any). */
    @Override
    protected V bucketRemove(int hash, K key) {
        int j = findSlot(hash, key);
        if (j < 0) {
            return null;
        }
        V answer = table[j].getValue();
        table[j] = DEFUNCT;
        decreaseSize(1);
        return answer;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++) {
            if (!isAvailable(h)) {
                buffer.add(table[h]);
            }
        }
        return buffer;
    }
}
