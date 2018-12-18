package learn.dsai.ch08trees;

public class NodeLong {
    final long data;
    NodeLong left;
    NodeLong right;

    public NodeLong(long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Long.toString(data);
    }
}
