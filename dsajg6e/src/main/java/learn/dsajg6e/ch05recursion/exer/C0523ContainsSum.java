package learn.dsajg6e.ch05recursion.exer;

/**
 * Describe a recursive algorithm that will check if an array A of integers contains
 * an integer A[i] that is the sum of two integers that appear earlier in A, that is, such
 * that A[i] = A[j] + A[k] for j,k < i
 */
public class C0523ContainsSum {

    static final int[] NONE = {-1, -1, -1};

    static int[] containsSumOfTwo(int[] a) {
        if (a.length < 3) {
            return NONE;
        }
        return containsSumOfTwo(a, 0);
    }

    private static int[] containsSumOfTwo(int[] a, int start) {
        if (start == a.length - 2) {
            return NONE;
        }
        int first = a[start];
        for (int j = start + 1; j < a.length - 1; j++) {
            for (int k = j + 1; k < a.length; k++) {
                if (first + a[j] == a[k]) {
                    return new int[]{start, j, k};
                }
            }
        }
        return containsSumOfTwo(a, start + 1);
    }
}
