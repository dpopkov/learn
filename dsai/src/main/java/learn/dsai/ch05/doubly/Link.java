package learn.dsai.ch05.doubly;

public class Link {
    public final long data;
    public Link next;
    public Link prev;

    public Link(long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Long.toString(data);
    }
}
