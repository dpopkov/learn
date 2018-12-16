package learn.dsai.ch11ht;

/**
 * A hash tables that contains generic elements.
 * @param <T> type of the elements
 */
public interface HashTableT<T> {
    KeyT<T> find(T key);
    void insert(T keyValue);
    KeyT<T> delete(T key);
    int getSize();
}
