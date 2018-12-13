package learn.dsai.ch11ht.doubleh;

import learn.dsai.ch11ht.DataItem;

import java.util.StringJoiner;

/**
 * Demonstrates hash table with double hashing.
 */
public class HashTable {
    private static final int DEFAULT_CAPACITY = 11;
    private static final DataItem DELETED = new DataItem(-1L);
    private static final int SECOND_HASH_CONST = 5;

    private DataItem[] items;
    private int size;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    /** Constructor is used for unit-testing purposes. */
    HashTable(int capacity) {
        items = new DataItem[capacity];
    }

    /** Constructor is used for unit-testing purposes. */
    HashTable(DataItem[] items, int size) {
        this.items = items;
        this.size = size;
    }

    /**
     * Finds the item with the specified key.
     * The table should not be full, but if it is, this method
     * would loop forever.
     * @param key key to find
     * @return found item or null
     */
    public DataItem find(long key) {
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

    public void insert(DataItem item) {
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

    private void rehash() {
        int newCapacity = getPrimeAfter(items.length * 2);
        DataItem[] newItems = new DataItem[newCapacity];
        for (DataItem item : items) {
            if (item != null && item != DELETED) {
                insertTo(newItems, item);
            }
        }
        items = newItems;
    }

    private void insertTo(DataItem[] newItems, DataItem item) {
        int hash = (int) (item.getKey() % newItems.length);
        int step = hashFunc2(item.getKey());
        while (newItems[hash] != null) {
            hash += step;
            hash %= newItems.length;
        }
        newItems[hash] = item;
    }

    public DataItem delete(long key) {
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

    public int getSize() {
        return size;
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

    private static int getPrimeAfter(int min) {
        for (int j = min + 1; true; j++) {
            if (isPrime(j)) {
                return j;
            }
        }
    }

    private static boolean isPrime(int x) {
        if (x > 2 && x % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
