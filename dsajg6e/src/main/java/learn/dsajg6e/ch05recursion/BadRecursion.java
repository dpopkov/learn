package learn.dsajg6e.ch05recursion;

/**
 * Examples of inefficient recursion.
 */
@SuppressWarnings("unused")
public class BadRecursion {
    /**
     * Returns true if there are no duplicate values from data[low] through data[high].
     * The running time is O(2^n).
     * */
    @SuppressWarnings({"BooleanMethodIsAlwaysInverted", "unused"})
    public static boolean unique3(int[] data, int low, int high) {
        if (low >= high) {
            return true;
        } else if (!unique3(data, low, high - 1)) {
            return false;
        } else if (!unique3(data, low + 1, high)) {
            return false;
        } else {
            return data[low] != data[high];
        }
    }

    /**
     * Returns the n-th Fibonacci number (inefficiently).
     */
    public static long fibonacciBad(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciBad(n - 2) + fibonacciBad(n - 1);
        }
    }
}
