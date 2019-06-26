package learn.dsajg6e.ch05recursion;

/**
 * Example of fibonacci recursion. The running time is O(n).
 */
@SuppressWarnings("unused")
public class GoodRecursion {
    /** Returns array containing the pair of Fibonacci numbers, F(n) and F(n−1). */
    public static long[] fibonacciGood(int n) {
        if (n <= 1) {
            return new long[]{n, 0};
        } else {
            long[] temp = fibonacciGood(n - 1);
            return new long[]{temp[0] + temp[1], temp[0]};
        }
    }
}
