package learn.dsajg6e.ch10maps;

import learn.dsajg6e.ch09pq2.Entry;

import java.util.ArrayList;
import java.util.Random;

/**
 * Abstract hash map that contains higher level commonalities to different hashing algorithms.
 * It provides mathematical support in the form of a hash compression function using a randomized
 * Multiply-Add-and-Divide (MAD) formula, and support for automatically resizing the underlying hash
 * table when the load factor reaches a certain threshold.
 * It does not provide any concrete representation of a table of buckets.
 * Every concrete subclass must implement a number of abstract methods of this class.
 */
public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    protected static final int DEFAULT_PRIME = 109345121;
    protected static final int DEFAULT_CAPACITY = 17;

    /** Current number of entries in the map. */
    private int n = 0;
    /** Length of the table. */
    protected int capacity;
    /** Prime factor. */
    private final int prime;
    /** The scaling factor. */
    private final long scale;
    /** The shift factor. */
    private final long shift;

    public AbstractHashMap(int capacity, int prime) {
        this.capacity = capacity;
        this.prime = prime;
        Random rand = new Random();
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }

    public AbstractHashMap(int capacity) {
        this(capacity, DEFAULT_PRIME);
    }

    public AbstractHashMap() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int size() {
        return n;
    }

    protected void increaseSize(int growth) {
        n += growth;
    }

    protected void decreaseSize(int reduction) {
        n -= reduction;
    }

    @Override
    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    @Override
    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }

    @Override
    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        if (n > capacity / 2) {
            resize(2 * capacity - 1);
        }
        return answer;
    }

    /* Private utilities. */

    private void resize(int newCapacity) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (Entry<K, V> e : entrySet()) {
            buffer.add(e);
        }
        capacity = newCapacity;
        createTable();
        n = 0;
        for (Entry<K, V> e : buffer) {
            put(e.getKey(), e.getValue());
        }
    }

    /**
     * Calculates the hash value relying on an original key's hash code, followed by MAD compression based
     * on a prime number and the scale and shift parameters that are randomly chosen in the constructor.
     * @param key the key
     * @return hash value that can be used to access a bucket in the underlying hash table.
     */
    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    /* Protected abstract methods to be implemented by subclasses. */

    /** Should create an initially empty table having size equal to a designated {@code capacity} instance variable. */
    protected abstract void createTable();

    /**
     * Should mimic the semantics of the public {@code get} method,
     * but for a key that is known to hash to bucket {@code hash}.
     */
    protected abstract V bucketGet(int hash, K key);

    /**
     * Should mimic the semantics of the public {@code put} method,
     * but for a key that is known to hash to bucket {@code hash}.
     */
    protected abstract V bucketPut(int hash, K key, V value);

    /**
     * Should mimic the semantics of the public {@code remove} method,
     * but for a key that is known to hash to bucket {@code hash}.
     */
    protected abstract V bucketRemove(int hash, K key);
}
