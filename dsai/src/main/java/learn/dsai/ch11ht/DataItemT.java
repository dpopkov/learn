package learn.dsai.ch11ht;

/**
 * Data item that contains generic elements.
 * @param <T> type of the elements
 */
public class DataItemT<T> implements KeyT<T> {
    private final T key;

    public DataItemT(T key) {
        this.key = key;
    }

    @Override
    public T getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "{" + key + "}";
    }
}
