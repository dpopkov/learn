package learn.dsai.ch05.adt;

/**
 * Node in a single linked list that contains values of type {@code long}.
 */
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
