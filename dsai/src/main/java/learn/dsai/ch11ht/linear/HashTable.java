package learn.dsai.ch11ht.linear;

import learn.dsai.ch11ht.DataItem;

import java.util.StringJoiner;

/**
 * Demonstrates hash table with linear probing.
 */
public class HashTable {
    private static final int DEFAULT_CAPACITY = 10;
    private static final DataItem DELETED = new DataItem(-1L);

    private final DataItem[] items;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        items = new DataItem[capacity];
    }

    /** Constructor used for unit-testing purposes. */
    HashTable(DataItem[] items) {
        this.items = items;
    }

    /**
     * Finds the item with the specified key.
     * The table should not be full, but if it is, this method
     * would loop forever.
     * @param key key to find
     * @return found item or null
     */
    public DataItem find(long key) {
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

    public void insert(DataItem item) {
        int hash = hashFunc(item.getKey());
        while (items[hash] != null && items[hash] != DELETED) {
            hash++;
            hash %= items.length;
        }
        items[hash] = item;
    }

    public DataItem delete(long key) {
        int hash = hashFunc(key);
        DataItem item = null;
        while (items[hash] != null) {
            if (items[hash].getKey() == key) {
                item = items[hash];
                items[hash] = DELETED;
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

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" ", "[", "]");
        for (DataItem item : items) {
            joiner.add(item != null && item != DELETED
                    ? Long.toString(item.getKey()) : "**");
        }
        return joiner.toString();
    }

    public void display() {
        System.out.println("Table: " + toString());
    }
}
