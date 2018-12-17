package learn.dsai.tools;

public class MathTools {
    /**
     * Returns the base 2 logarithms of an argument that is power of 2.
     * @param x positive power of 2 (1, 2, 4, 8, 16, ...)
     * @return the base 2 logarithm
     */
    public static int log2OfPowerOf2(int x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Must be positive power of 2: " + x);
        }
        if (Integer.bitCount(x) != 1) {
            throw new IllegalArgumentException("Not power of two: " + x);
        }
        return Integer.numberOfTrailingZeros(x);
    }

    public static int pow(int x, int p) {
        if (p < 0) {
            throw new IllegalArgumentException("Negative exponent: " + p);
        }
        int rst = 1;
        while (p > 0) {
            if (p % 2 == 0) {
                x *= x;
                p /= 2;
            } else {
                rst *= x;
                p--;
            }
        }
        return rst;
    }

    public static boolean isPrime(int x) {
        if (x > 2 && x % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
