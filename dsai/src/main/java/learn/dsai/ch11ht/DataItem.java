package learn.dsai.ch11ht;

public class DataItem {
    private long key;

    public DataItem(long key) {
        this.key = key;
    }

    public long getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "{" + key + "}";
    }
}
