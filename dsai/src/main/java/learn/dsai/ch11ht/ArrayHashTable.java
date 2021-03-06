package learn.dsai.ch11ht;

import learn.dsai.tools.MathTools;

import java.util.StringJoiner;

/**
 * Base class should be used for hash tables that
 * use array of items as underlying container.
 */
public abstract class ArrayHashTable implements HashTableLong {
    protected static final DataItem DELETED = new DataItem(-1L);

    protected DataItem[] items;
    protected int size;

    /** Constructor is used for unit-testing purposes. */
    public ArrayHashTable(int capacity) {
        items = new DataItem[capacity];
    }

    public ArrayHashTable(DataItem[] items, int size) {
        this.items = items;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    /** This method should be implemented in concrete {@code HashTableLong}
     * implementation as it is used in rehashing.
     * @param newItems new array of items
     * @param item existing item
     */
    public abstract void insertTo(DataItem[] newItems, DataItem item);

    protected void rehash() {
        int newCapacity = getPrimeAfter(items.length * 2);
        DataItem[] newItems = new DataItem[newCapacity];
        for (DataItem item : items) {
            if (item != null && item != DELETED) {
                insertTo(newItems, item);
            }
        }
        items = newItems;
    }

    private static int getPrimeAfter(int min) {
        for (int j = min + 1; true; j++) {
            if (MathTools.isPrime(j)) {
                return j;
            }
        }
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
