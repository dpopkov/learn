package learn.dsai.ch11ht.doubleh;

import learn.dsai.ch11ht.ArrayHashTable;
import learn.dsai.ch11ht.DataItem;
import learn.dsai.ch11ht.HashTableLong;
import learn.dsai.ch11ht.KeyLong;

/**
 * Demonstrates hash table with double hashing.
 */
public class HashTable extends ArrayHashTable implements HashTableLong {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int SECOND_HASH_CONST = 5;

    public HashTable() {
        super(DEFAULT_CAPACITY);
    }

    /** Constructor is used for unit-testing purposes. */
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
        int hash = hashFunc1(key);
        if (items[hash] != null && items[hash].getKey() == key) {
            return items[hash];
        }
        int step = hashFunc2(key);
        hash += step;
        while (items[hash] != null) {
            if (items[hash].getKey() == key) {
                return items[hash];
            }
            hash += step;
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
        int hash = hashFunc1(item.getKey());
        if (items[hash] == null || items[hash] == DELETED) {
            items[hash] = item;
            size++;
        } else {
            int step = hashFunc2(item.getKey());
            do {
                hash += step;
                hash %= items.length;
            } while (items[hash] != null && items[hash] != DELETED);
            items[hash] = item;
            size++;
        }
    }

    @Override
    public void insertTo(DataItem[] newItems, DataItem item) {
        int hash = (int) (item.getKey() % newItems.length);
        int step = hashFunc2(item.getKey());
        while (newItems[hash] != null) {
            hash += step;
            hash %= newItems.length;
        }
        newItems[hash] = item;
    }

    @Override
    public KeyLong delete(long key) {
        int hash = hashFunc1(key);
        int step = hashFunc2(key);
        DataItem item = null;
        while (items[hash] != null) {
            if (items[hash].getKey() == key) {
                item = items[hash];
                items[hash] = DELETED;
                size--;
                break;
            }
            hash += step;
            hash %= items.length;
        }
        return item;
    }

    private int hashFunc1(long key) {
        return (int) (key % items.length);
    }

    /**
     * Calculates 2nd hash value, non-zero, less than array size,
     * different from 1st hash value.
     * Array size must be relatively prime to 5, 4, 3, and 2.
     * @param key key value
     * @return second hash value
     */
    private int hashFunc2(long key) {
        return (int) (SECOND_HASH_CONST - (key % SECOND_HASH_CONST));
    }
}
