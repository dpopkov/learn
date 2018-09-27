package learn.ijpds.ch19generics.exercises;

public class E1905Triplet<T> extends E1903Pair<T> {
    private final T third;

    public E1905Triplet(T first, T second, T third) {
        super(first, second);
        this.third = third;
    }

    public T getThird() {
        return third;
    }

    @Override
    public String toString() {
        return "[" + this.getFirst() + ", " + this.getSecond() + ", " + this.getThird() + "]";
    }

    public static void main(String[] args) {
        E1905Triplet<String> t = new E1905Triplet<>("A", "B", "C");
        System.out.println(t);
        System.out.println(t.getFirst());
        System.out.println(t.getSecond());
        System.out.println(t.getThird());
    }
}
