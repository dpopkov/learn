package learn.dsai.ch11ht.linear;

import learn.dsai.ch11ht.DataItem;

public class HashTable {
    private DataItem[] items;
    private int nElems;

    /** Constructor used for unit-testing purposes. */
    HashTable(DataItem[] items, int nElems) {
        this.items = items;
        this.nElems = nElems;
    }

    public DataItem find(long key) {
        int hash = hashFunc(key);
        while (items[hash] != null) {
            if (items[hash].getKey() == key) {
                return items[hash];
            }
            hash++;
            hash %= items.length;
        }
        return null;
    }

    private int hashFunc(long key) {
        return (int) (key % items.length);
    }
}
