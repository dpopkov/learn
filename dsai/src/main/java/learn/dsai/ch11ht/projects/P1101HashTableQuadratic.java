package learn.dsai.ch11ht.projects;

import learn.dsai.ch11ht.ArrayHashTable;
import learn.dsai.ch11ht.DataItem;
import learn.dsai.ch11ht.HashTableLong;
import learn.dsai.ch11ht.KeyLong;

/**
 * Hash table that uses quadratic probing.
 */
public class P1101HashTableQuadratic extends ArrayHashTable implements HashTableLong {
    private static final int DEFAULT_CAPACITY = 10;

    public P1101HashTableQuadratic() {
        this(DEFAULT_CAPACITY);
    }

    public P1101HashTableQuadratic(int capacity) {
        super(capacity);
    }

    /** Constructor used for unit-testing purposes. */
    P1101HashTableQuadratic(DataItem[] items, int size) {
        super(items, size);
    }

    /**
     * Finds the item with the specified key.
     * The table should not be full, but if it is, this method
     * would loop forever.
     * @param key key to find
     * @return found item or null
     */
    @Override
    public KeyLong find(long key) {
        int hash = hashFunc(key);
        int stepIdx = 1;
        while (items[hash] != null) {
            if (items[hash].getKey() == key) {
                return items[hash];
            }
            hash += stepIdx * stepIdx;
            stepIdx++;
            /* Wraps around to the beginning if necessary.*/
            hash %= items.length;
        }
        return null;
    }

    @Override
    public void insert(long keyValue) {
        DataItem item = new DataItem(keyValue);
        if (size + 1 > items.length * 0.66) {
            rehash();
        }
        int stepIdx = 1;
        int hash = hashFunc(item.getKey());
        while (items[hash] != null && items[hash] != DELETED) {
            hash += stepIdx * stepIdx;
            stepIdx++;
            hash %= items.length;
        }
        items[hash] = item;
        size++;
    }

    @Override
    public void insertTo(DataItem[] newItems, DataItem item) {
        int hash = (int) (item.getKey() % newItems.length);
        int stepIdx = 1;
        while (newItems[hash] != null) {
            hash += stepIdx * stepIdx;
            stepIdx++;
            hash %= newItems.length;
        }
        newItems[hash] = item;
    }

    @Override
    public DataItem delete(long key) {
        int hash = hashFunc(key);
        DataItem item = null;
        int stepIdx = 1;
        while (items[hash] != null) {
            if (items[hash].getKey() == key) {
                item = items[hash];
                items[hash] = DELETED;
                size--;
                break;
            }
            hash += stepIdx * stepIdx;
            stepIdx++;
            hash %= items.length;
        }
        return item;
    }

    private int hashFunc(long key) {
        return (int) (key % items.length);
    }
}

