package learn.dsai.ch11ht;

/**
 * A hash tables that contains long values.
 */
public interface HashTableLong {
    DataItem find(long key);
    void insert(DataItem item);
    DataItem delete(long key);

    /** This method should be implemented in concrete {@code HashTableLong}
     * implementation as it is used in rehashing.
     * @param newItems new array of items
     * @param item existing item
     */
    void insertTo(DataItem[] newItems, DataItem item);
}
