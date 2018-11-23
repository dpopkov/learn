package learn.dsai.ch05.adt;

public class Link {
    public final long data;
    public Link next;

    public Link(long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" + data + '}';
    }
}
