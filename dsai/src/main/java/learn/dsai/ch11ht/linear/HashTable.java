package learn.dsai.ch11ht.linear;

import learn.dsai.ch11ht.ArrayHashTable;
import learn.dsai.ch11ht.DataItem;
import learn.dsai.ch11ht.HashTableLong;
import learn.dsai.ch11ht.KeyLong;

/**
 * Demonstrates hash table with linear probing.
 */
public class HashTable extends ArrayHashTable implements HashTableLong {
    private static final int DEFAULT_CAPACITY = 10;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        super(capacity);
    }

    /** Constructor used for unit-testing purposes. */
    HashTable(DataItem[] items, int size) {
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
        while (items[hash] != null) {
            if (items[hash].getKey() == key) {
                return items[hash];
            }
            hash++;
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
        int hash = hashFunc(item.getKey());
        while (items[hash] != null && items[hash] != DELETED) {
            hash++;
            hash %= items.length;
        }
        items[hash] = item;
        size++;
    }

    @Override
    public void insertTo(DataItem[] newItems, DataItem item) {
        int hash = (int) (item.getKey() % newItems.length);
        while (newItems[hash] != null) {
            hash++;
            hash %= newItems.length;
        }
        newItems[hash] = item;
    }

    @Override
    public DataItem delete(long key) {
        int hash = hashFunc(key);
        DataItem item = null;
        while (items[hash] != null) {
            if (items[hash].getKey() == key) {
                item = items[hash];
                items[hash] = DELETED;
                size--;
                break;
            }
            hash++;
            hash %= items.length;
        }
        return item;
    }

    private int hashFunc(long key) {
        return (int) (key % items.length);
    }
}
