package learn.dsai.ch10tree234;

public class DataItem {
    private final long data;

    public DataItem(long data) {
        this.data = data;
    }

    public long getData() {
        return data;
    }

    @Override
    public String toString() {
        return "/" + data;
    }
}
