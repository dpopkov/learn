/* 11.3 */
package learn.dsai.ch11ht.chained;

import learn.dsai.ch11ht.HashTableLong;
import learn.dsai.ch11ht.KeyLong;

import java.util.StringJoiner;

/**
 * Hash table that uses separate chaining.
 */
public class HashTable implements HashTableLong {
    private final SortedList[] array;
    private int size;

    public HashTable(int hashArraySize) {
        array = new SortedList[hashArraySize];
        for (int i = 0; i < array.length; i++) {
            array[i] = new SortedList();
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public KeyLong find(long key) {
        int hash = hashFunc(key);
        return array[hash].find(key);
    }

    @Override
    public void insert(long keyValue) {
        int hash = hashFunc(keyValue);
        array[hash].insert(new Link(keyValue));
        size++;
    }

    private int hashFunc(long keyValue) {
        return (int) (keyValue % array.length);
    }

    @Override
    public KeyLong delete(long key) {
        int hash = hashFunc(key);
        Link deleted = array[hash].delete(key);
        if (deleted != null) {
            size--;
        }
        return deleted;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (int i = 0; i < array.length; i++) {
            joiner.add(i + ": " + array[i].toString());
        }
        return joiner.toString();
    }
}
