package learn.ijpds.ch19generics.exercises;

public class E1906Transition<T, U, V> extends E1906Association<T, U> {
    private final V third;

    E1906Transition(T first, U second, V third) {
        super(first, second);
        this.third = third;
    }

    public V getThird() {
        return third;
    }
}
