/*
13.15
Use Big Integer for the Rational class.
 */
package learn.ijpds.ch13abstract.exercises;

import learn.ijpds.tools.GcdBig;

import java.math.BigInteger;

public class E1315Rational extends Number implements Comparable<E1315Rational> {
    private BigInteger numerator;
    private BigInteger denominator;

    public E1315Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    public E1315Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = GcdBig.gcd(numerator, denominator);
        BigInteger m = denominator.compareTo(BigInteger.ZERO) > 0 ? BigInteger.ONE : BigInteger.ONE.negate();
        this.numerator = numerator.multiply(m).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public E1315Rational add(E1315Rational second) {
        BigInteger n = numerator.multiply(second.getDenominator()).add(denominator.multiply(second.getNumerator()));
        BigInteger d = denominator.multiply(second.getDenominator());
        return new E1315Rational(n, d);
    }

    public E1315Rational subtract(E1315Rational second) {
        BigInteger n = numerator.multiply(second.getDenominator()).subtract(denominator.multiply(second.getNumerator()));
        BigInteger d = denominator.multiply(second.getDenominator());
        return new E1315Rational(n, d);
    }

    public E1315Rational multiply(E1315Rational second) {
        BigInteger n = numerator.multiply(second.getNumerator());
        BigInteger d = denominator.multiply(second.getDenominator());
        return new E1315Rational(n, d);
    }

    public E1315Rational divide(E1315Rational second) {
        BigInteger n = numerator.multiply(second.getDenominator());
        BigInteger d = denominator.multiply(second.getNumerator());
        return new E1315Rational(n, d);
    }

    @Override
    public String toString() {
        return denominator.equals(BigInteger.ONE) ? numerator + "" : numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (!getClass().equals(other.getClass())) return false;
        E1315Rational second = (E1315Rational) other;
        return subtract(second).getNumerator().equals(BigInteger.ZERO);
    }

    @Override
    public int compareTo(E1315Rational o) {
        BigInteger n = subtract(o).getNumerator();
        int r = n.compareTo(BigInteger.ZERO);
        if (r > 0) {
            return 1;
        } else if (r < 0) {
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
        return numerator.doubleValue() / denominator.doubleValue();
    }
}
