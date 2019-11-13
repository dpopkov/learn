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
    protected static final double DEFAULT_LOAD_FACTOR = 0.5;
    protected static final double MINIMUM_LOAD_FACTOR = 0.25;

    /** Current number of entries in the map. */
    protected int size = 0;
    /** Length of the table. */
    protected int capacity;
    /** Load factor when the hash table is resized. */
    private final double loadFactor;
    /** Prime factor. */
    private final int prime;
    /** The scaling factor. */
    private final long scale;
    /** The shift factor. */
    private final long shift;

    public AbstractHashMap(int capacity, double loadFactor, int prime) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.prime = prime;
        Random rand = new Random();
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable(capacity);
    }

    /* This constructor should be used for testing of sub-classes. */
    public AbstractHashMap(int capacity, double loadFactor, int prime, long scale, long shift) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.prime = prime;
        this.scale = scale;
        this.shift = shift;
        createTable(capacity);
    }

    public AbstractHashMap(int capacity, double loadFactor) {
        this(capacity, loadFactor, DEFAULT_PRIME);
    }

    public AbstractHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    @Override
    public int size() {
        return size;
    }

    protected void increaseSize(int growth) {
        size += growth;
    }

    protected void decreaseSize(int reduction) {
        size -= reduction;
    }

    @Override
    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    /* C-10.36 */
    public boolean containsKey(K key) {
        return bucketContainsKey(hashValue(key), key);
    }

    @Override
    public V remove(K key) {
        V value = bucketRemove(hashValue(key), key);
        if ((double) size / capacity < MINIMUM_LOAD_FACTOR) {
            capacity = capacity / 2;
            resize(capacity);
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        ensureSizeWithinLoadFactor();
        return answer;
    }

    /**
     * Adds the specified key-value pair to map only if there does not yet exist
     * some other entry with the specified key.
     * Returns the found existing value or null.
     */
    public V putIfAbsent(K key, V value) {
        V answer = bucketPutIfAbsent(hashValue(key), key, value);
        ensureSizeWithinLoadFactor();
        return answer;
    }

    protected void ensureSizeWithinLoadFactor() {
        if ((double) size / capacity > loadFactor) {
            int newCapacity = 2 * capacity - 1;
            newCapacity = newCapacity > capacity ? newCapacity : capacity * 2;
            resize(newCapacity);
        }
    }

    /* Private utilities. */

    protected void resize(int newCapacity) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (Entry<K, V> e : entrySet()) {
            buffer.add(e);
        }
        capacity = newCapacity;
        createTable(capacity);
        size = 0;
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
    protected int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    /* Protected abstract methods to be implemented by subclasses. */

    /** Should create an initially empty table having size equal to a designated {@code capacity} instance variable. */
    protected abstract void createTable(int capacity);

    /**
     * Should mimic the semantics of the public {@code get} method,
     * but for a key that is known to hash to bucket {@code hash}.
     */
    protected abstract V bucketGet(int hash, K key);

    /* C-10.36 */
    /**
     * Should mimic the semantics of the public {@code containsKey} method,
     * but for a key that is known to hash to bucket {@code hash}.
     */
    protected abstract boolean bucketContainsKey(int hash, K key);

    /**
     * Should mimic the semantics of the public {@code put} method,
     * but for a key that is known to hash to bucket {@code hash}.
     */
    protected abstract V bucketPut(int hash, K key, V value);

    /* C-10.34 */
    /**
     * Should mimic the semantics of the public {@code putIfAbsent} method,
     * but for a key that is known to hash to bucket {@code hash}.
     */
    protected abstract V bucketPutIfAbsent(int hash, K key, V value);

    /**
     * Should mimic the semantics of the public {@code remove} method,
     * but for a key that is known to hash to bucket {@code hash}.
     */
    protected abstract V bucketRemove(int hash, K key);
}
