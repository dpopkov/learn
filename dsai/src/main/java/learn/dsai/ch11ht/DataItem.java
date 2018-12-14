package learn.dsai.ch11ht;

/**
 * Data item that contains {@code long} values.
 */
public class DataItem implements KeyLong {
    private final long key;

    public DataItem(long key) {
        this.key = key;
    }

    @Override
    public long getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "{" + key + "}";
    }
}
