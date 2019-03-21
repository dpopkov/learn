package learn.hackerrank.common;

import java.util.Objects;

public class Pair <T> {
    private final T first;
    private final T second;

    private Pair() {
        first = null;
        second = null;
    }

    private Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public boolean isEmpty() {
        return first != null && second != null;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public static <T> Pair<T> of(T t1, T t2) {
        return new Pair<>(t1, t2);
    }

    public static <T> Pair<T> empty() {
        return new Pair<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?> pair = (Pair<?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Pair{first=" + first + ", second=" + second + '}';
    }
}
