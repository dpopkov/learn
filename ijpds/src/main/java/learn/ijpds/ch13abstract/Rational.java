package learn.ijpds.ch13abstract;

public class Rational extends Number implements Comparable<Rational> {
    public static final Rational ZERO = new Rational(0, 1);

    private long numerator;
    private long denominator;

    public Rational() {
        this(0, 1);
    }

    public Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        this.numerator = (denominator > 0 ? 1 : -1) * numerator / gcd;
        this.denominator = Math.abs(denominator) / gcd;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Rational add(Rational second) {
        long n = n = numerator * second.getDenominator() + denominator * second.getNumerator();
        long d = denominator * second.getDenominator();
        return new Rational(n, d);
    }

    public Rational subtract(Rational second) {
        long n = n = numerator * second.getDenominator() - denominator * second.getNumerator();
        long d = denominator * second.getDenominator();
        return new Rational(n, d);
    }

    public Rational multiply(Rational second) {
        long n = numerator * second.getNumerator();
        long d = denominator * second.getDenominator();
        return new Rational(n, d);
    }

    public Rational divide(Rational second) {
        long n = numerator * second.getDenominator();
        long d = denominator * second.getNumerator();
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        return denominator == 1 ? numerator + "" : numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (!getClass().equals(other.getClass())) return false;
        Rational second = (Rational) other;
        return subtract(second).getNumerator() == 0;
    }

    private static long gcd(long n, long d) {
        long n1 = Math.abs(n);
        long n2 = Math.abs(d);
        int gcd = 1;
        for (int k = 1; k <= n1 && k <= n2; k++) {
            if (n1 % k == 0 && n2 % k == 0) {
                gcd = k;
            }
        }
        return gcd;
    }

    @Override
    public int compareTo(Rational o) {
        long n = subtract(o).getNumerator();
        if (n > 0) {
            return 1;
        } else if (n < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public int intValue() {
        return (int)doubleValue();
    }

    @Override
    public long longValue() {
        return (long)doubleValue();
    }

    @Override
    public float floatValue() {
        return (float)doubleValue();
    }

    @Override
    public double doubleValue() {
        return (double)numerator / denominator;
    }
}
