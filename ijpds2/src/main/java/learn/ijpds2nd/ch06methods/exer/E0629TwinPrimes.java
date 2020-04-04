package learn.ijpds2nd.ch06methods.exer;

import java.util.Objects;

public class E0629TwinPrimes {
    static class Twins {
        private final int x;
        private final int y;

        public Twins(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }

        static Twins of(int x, int y) {
            return new Twins(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Twins twins = (Twins) o;
            return x == twins.x &&
                    y == twins.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private Twins current;

    public E0629TwinPrimes(Twins twins) {
        current = twins;
    }

    public Twins nextTwinPrimes() {
        int a = current.getY();
        int b = a + 2;
        while (!arePrimes(a, b)) {
            a = b;
            b = a + 2;
        }
        current = Twins.of(a, b);
        return current;
    }

    private boolean arePrimes(int x, int y) {
        boolean primes = true;
        for (int divisor = 2; divisor <= y / 2; divisor++) {
            if (x % divisor == 0 || y % divisor == 0) {
                primes = false;
                break;
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        Twins tw0 = new Twins(3, 5);
        System.out.println(tw0);

        E0629TwinPrimes generator = new E0629TwinPrimes(tw0);
        Twins tw;
        while (true) {
            tw = generator.nextTwinPrimes();
            if (tw.getY() < 1_200) {
                System.out.println(tw);
            } else {
                break;
            }
        }
    }
}
