package learn.dsajg6e.ch05recursion;

/**
 * Examples of linear recursion.
 */
@SuppressWarnings("unused")
public class LinearRecursion {
    /** Computes the sum of the first n integers of the given array. */
    public static int linearSum(int[] data, int n) {
        if (n == 0) {
            return 0;
        } else {
            return linearSum(data, n - 1) + data[n - 1];
        }
    }

    /** Reverses the contents of subarray data[low] through data[high] inclusive. */
    public static void reverseArray(int[] data, int low, int high) {
        if (low < high) {
            int tmp = data[low];
            data[low] = data[high];
            data[high] = tmp;
            reverseArray(data, low + 1, high - 1);
        }
    }

    /** Computes the value of x raised to the n-th power, for non-negative n. */
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x,n - 1);
        }
    }

    /**
     * Computes the value of x raised to the n-th power, for non-negative n.
     * Optimized version.
     * */
    public static double power2(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double partial = power(x, n / 2);
            double result = partial * partial;
            if (n % 2 == 1) {
                result *= x;
            }
            return result;
        }
    }
}
