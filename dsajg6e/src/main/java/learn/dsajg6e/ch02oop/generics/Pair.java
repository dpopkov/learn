package learn.dsajg6e.ch02oop.generics;

@SuppressWarnings("unused")
public class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" + first + ", " + second + '}';
    }

    public static <K, V> Pair<K, V> of(K first, V second) {
        return new Pair<>(first, second);
    }

    public static void main(String[] args) {
        Pair[] nonGeneric = new Pair[2];
        @SuppressWarnings("unchecked") Pair<String, Long>[] pa = nonGeneric;
        Pair<String, Long> p1 = new Pair<>("One", 1L);
        Pair<String, Long> p2 = new Pair<>("Two", 2L);
        pa[0] = p1;
        pa[1] = p2;
        System.out.println(pa[0].getFirst());
        System.out.println(pa[1].getFirst());
        System.out.println("Example of bad type safety:");
        nonGeneric[0] = new Pair<>(3L, "three");
        try {
            System.out.println(pa[0].getFirst());
        } catch (ClassCastException e) {
            System.out.println("ClassCastException is expected.");
        }
    }
}
