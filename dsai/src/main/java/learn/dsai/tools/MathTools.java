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
}
