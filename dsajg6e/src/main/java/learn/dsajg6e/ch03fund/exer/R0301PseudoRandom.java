package learn.dsajg6e.ch03fund.exer;

/**
 * Pseudo random number generator that generates the next number
 * from the current number, according to the formula:
 * next = (a * current + b) % n.
 */
@SuppressWarnings("SameParameterValue")
public class R0301PseudoRandom {
    private static final R0301PseudoRandom instance = new R0301PseudoRandom(12, 5, 100, 92);

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(instance.next());
        }
    }

    private final int a;
    private final int b;
    private final int n;
    private int current;

    private R0301PseudoRandom(int a, int b, int n, int seed) {
        this.a = a;
        this.b = b;
        this.n = n;
        current = seed;
    }

    public int next() {
        current = next(current);
        return current;
    }

    private int next(int previous) {
        return (a * previous + b) % n;
    }
}
