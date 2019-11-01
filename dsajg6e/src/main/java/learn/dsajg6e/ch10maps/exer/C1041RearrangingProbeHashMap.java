package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch07list.ArrayList;
import learn.dsajg6e.ch09pq2.Entry;
import learn.dsajg6e.ch10maps.AbstractHashMap;

public class C1041RearrangingProbeHashMap<K, V> extends AbstractHashMap<K, V> {
    private MapEntry<K, V>[] table;

    public C1041RearrangingProbeHashMap() {
        super();
    }

    public C1041RearrangingProbeHashMap(int capacity, double loadFactor, int prime, long scale, long shift) {
        super(capacity, loadFactor, prime, scale, shift);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void createTable(int capacity) {
        table = (MapEntry<K, V>[]) new MapEntry[capacity];
    }

    @Override
    protected V bucketGet(int hash, K key) {
        V value = null;
        MapEntry<K, V> entry = table[hash];
        if (entry != null) {
            if (entry.getKey().equals(key)) {
                value = entry.getValue();
            } else {    // Collision
                int j = (hash + 1) % table.length;
                while (j != hash) {
                    entry = table[j];
                    if (entry == null) {
                        break;
                    } else if (entry.getKey().equals(key)) {
                        value = entry.getValue();
                        break;
                    }
                    j = (j + 1) % table.length;
                }
            }
        }
        return value;
    }

    @Override
    protected boolean bucketContainsKey(int hash, K key) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    protected V bucketPut(int hash, K key, V value) {
        MapEntry<K, V> me = table[hash];
        if (me == null) {
            insertToTable(hash, key, value);
        } else if (me.getKey().equals(key)) {
            return me.setValue(value);
        } else {
            int j = findFreeBucket(hash);
            if (j >= 0 && j < table.length) {
                insertToTable(j, key, value);
            } else {
                throw new IllegalStateException("Could not find free bucket");
            }
        }
        return null;
    }

    private void insertToTable(int index, K key, V value) {
        table[index] = new MapEntry<>(key, value);
        increaseSize(1);
    }

    @Override
    protected V bucketPutIfAbsent(int hash, K key, V value) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    protected V bucketRemove(int hash, K key) {
        Entry<K, V> entry = table[hash];
        if (entry == null) {
            return null;
        }
        if (entry.getKey().equals(key)) {
            V value = entry.getValue();
            table[hash] = null;
            decreaseSize(1);
            shiftLeftFrom(hash);
            return value;
        }
        return null;
    }

    private void shiftLeftFrom(int hash) {
        int i = hash;
        int j = (hash + 1) % table.length;
        while (j != hash && table[j] != null) {
            if (hashValue(table[j].getKey()) == hash) {
                table[i] = table[j];
                table[j] = null;
                i = j;
            }
            j++;
        }
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                buffer.add(entry);
            }
        }
        return buffer;
    }

    private int findFreeBucket(int hash) {
        int i = hash + 1;
        while (i != hash && i < table.length) {
            if (table[i] == null) {
                return i;
            }
            i = (i + 1) % table.length;
        }
        return -1;
    }
}
