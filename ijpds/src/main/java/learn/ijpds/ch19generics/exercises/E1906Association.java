package learn.ijpds.ch19generics.exercises;

public class E1906Association<T, U> {
    private final T first;
    private final U second;

    public E1906Association(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
