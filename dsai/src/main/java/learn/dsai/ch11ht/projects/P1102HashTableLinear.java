package learn.dsai.ch11ht.projects;

import learn.dsai.ch11ht.ArrayHashTableT;
import learn.dsai.ch11ht.DataItemT;
import learn.dsai.ch11ht.KeyT;

import java.util.function.ToIntFunction;

public class P1102HashTableLinear<T> extends ArrayHashTableT<T> {
    private final ToIntFunction<T> hashFunction;

    public P1102HashTableLinear(int capacity, ToIntFunction<T> hashFunction) {
        super(capacity);
        this.hashFunction = hashFunction;
    }

    public P1102HashTableLinear(DataItemT<T>[] items, int size, ToIntFunction<T> hashFunction) {
        super(items, size);
        this.hashFunction = hashFunction;
    }

    @Override
    public KeyT<T> find(T key) {
        int hash = hashFunc(key);
        while (items[hash] != null && items[hash] != DELETED) {
            if (items[hash].getKey().equals(key)) {
                return items[hash];
            }
            hash++;
            hash %= items.length;
        }
        return null;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void insert(T keyValue) {
        if (size + 1 > items.length * 0.66) {
            rehash();
        }
        int hash = hashFunc(keyValue);
        while (items[hash] != null && items[hash] != DELETED) {
            hash++;
            hash %= items.length;
        }
        items[hash] = new DataItemT<>(keyValue);
        size++;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void insertTo(DataItemT<T>[] newItems, DataItemT<T> item) {
        int hash = hashFunction.applyAsInt(item.getKey());
        hash %= newItems.length;
        while (newItems[hash] != null && newItems[hash] != DELETED) {
            hash++;
            hash %= newItems.length;
        }
        newItems[hash] = item;
    }

    @Override
    public KeyT<T> delete(T key) {
        int hash = hashFunc(key);
        DataItemT<T> item = null;
        while (items[hash] != null) {
            if (items[hash] != DELETED && items[hash].getKey().equals(key)) {
                item = items[hash];
                //noinspection unchecked
                items[hash] = DELETED;
                size--;
                break;
            }
            hash++;
            hash %= items.length;
        }
        return item;
    }

    private int hashFunc(T key) {
        int hash = hashFunction.applyAsInt(key);
        return hash % items.length;
    }
}
