package learn.ijpds.tools;

import learn.csia.utils.CliAppArgs;

import java.math.BigInteger;

/**
 * Implements greatest common denominator for positive BigIntegers.
 */
public class GcdBig {
    public static BigInteger gcd(BigInteger first, BigInteger second) {
        checkNegative(first);
        checkNegative(second);
        if (first.equals(second)) {
            return first;
        }
        int compare = first.compareTo(second);
        BigInteger numerator = compare < 0 ? first : second;
        BigInteger denominator = compare < 0 ? second : first;
        while (denominator.compareTo(BigInteger.ZERO) > 0) {
            BigInteger tmp = numerator.mod(denominator);
            numerator = denominator;
            denominator = tmp;
        }
        return numerator;
    }

    private static void checkNegative(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Cannot calculate for negative argument: " + value);
        }
    }

    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "First big", "Second big");
        String s1 = cli.nextString();
        String s2 = cli.nextString();
        BigInteger b1 = new BigInteger(s1);
        BigInteger b2 = new BigInteger(s2);
        BigInteger r = gcd(b1, b2);
        System.out.println("r = " + r);
    }
}
