package learn.dsajg6e.ch05recursion;

/** Examples of binary recursion. */
@SuppressWarnings("unused")
public class BinaryRecursion {
    /** Returns the sum of subarray data[low] through data[high] inclusive. */
    public static int binarySum(int[] data, int low, int high) {
        if (low == high) {
            return data[low];
        } else if (low > high) {
            return 0;
        } else {
            int mid = low + (high - low) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }
}
