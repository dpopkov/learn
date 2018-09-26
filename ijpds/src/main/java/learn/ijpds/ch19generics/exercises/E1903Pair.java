package learn.ijpds.ch19generics.exercises;

/**
 * Pair of objects of the same type.
 * @param <T> type of objects
 */
public class E1903Pair<T> {
    private final T first;
    private final T second;

    public E1903Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "[" + first + ", " + second + "]";
    }

    public static void main(String[] args) {
        E1903Pair<String> p = new E1903Pair<>("John", "Doe");
        System.out.println(p);
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());
    }
}
