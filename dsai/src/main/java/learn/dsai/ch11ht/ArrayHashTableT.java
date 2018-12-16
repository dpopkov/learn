package learn.dsai.ch11ht;

import learn.dsai.tools.MathTools;

import java.util.StringJoiner;

/**
 * Base class should be used for hash tables that
 * use array of generic items as underlying container.
 */
public abstract class ArrayHashTableT<T> implements HashTableT<T> {
    @SuppressWarnings("unchecked")
    protected static final DataItemT DELETED = new DataItemT(null);

    protected DataItemT<T>[] items;
    protected int size;

    /** Constructor is used for unit-testing purposes. */
    @SuppressWarnings("unchecked")
    public ArrayHashTableT(int capacity) {
        items = (DataItemT<T>[]) new DataItemT[capacity];
    }

    public ArrayHashTableT(DataItemT<T>[] items, int size) {
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
    public abstract void insertTo(DataItemT<T>[] newItems, DataItemT<T> item);

    protected void rehash() {
        int newCapacity = getPrimeAfter(items.length * 2);
        @SuppressWarnings("unchecked") DataItemT<T>[] newItems = new DataItemT[newCapacity];
        for (DataItemT<T> item : items) {
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
        for (DataItemT<T> item : items) {
            joiner.add(item != null && item != DELETED
                    ? item.getKey().toString() : "**");
        }
        return joiner.toString();
    }

    public void display() {
        System.out.println("Table: " + toString());
    }
}
