package learn.bj6e.common;

public class Pair<T> {
    private final T item1;
    private final T item2;

    public Pair(T item1, T item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public T getItem1() {
        return item1;
    }

    public T getItem2() {
        return item2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "item1=" + item1 +
                ", item2=" + item2 +
                '}';
    }
}
