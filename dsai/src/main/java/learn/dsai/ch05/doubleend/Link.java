package learn.dsai.ch05.doubleend;

public class Link {
    public final int data;
    public Link next;

    public Link(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" + data + '}';
    }
}
