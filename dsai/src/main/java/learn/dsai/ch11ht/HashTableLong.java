package learn.dsai.ch11ht;

/**
 * A hash tables that contains long values.
 */
public interface HashTableLong {
    KeyLong find(long key);
    void insert(long keyValue);
    KeyLong delete(long key);
}
