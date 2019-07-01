package learn.dsajg6e.ch05recursion.exer;

/**
 * Suppose you are given an array, A, containing n distinct integers that are listed
 * in increasing order. Given a number k, describe a recursive algorithm to find two
 * integers in A that sum to k, if such a pair exists.
 */
public class C0522SumToNumber {
    static final IntPair NONE = new IntPair(-1, -1);

    static IntPair findSummingTo(int[] a, int sum) {
        return findSummingTo(a, sum, 0, a.length - 1);
    }

    static IntPair findSummingTo(int[] a, int sum, int low, int high) {
        if (low >= high) {
            return NONE;
        } else if (a[low] + a[high] == sum) {
            return new IntPair(a[low], a[high]);
        }
        while (low < high && a[high] >= sum) {
            high--;
        }
        // low == high || a[high] < sum
        while (low < high && a[low] + a[high] < sum) {
            low++;
        }
        // low == high || a[low] + a[high] >= sum
        return findSummingTo(a, sum, low, high);
    }

}
