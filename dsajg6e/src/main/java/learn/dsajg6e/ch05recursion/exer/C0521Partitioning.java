package learn.dsajg6e.ch05recursion.exer;

/*
Given an unsorted array, A, of integers and an integer k, describe a recursive
algorithm for rearranging the elements in A so that all elements less than or equal
to k come before any elements larger than k.
 */
public class C0521Partitioning {
    static void partition(int[] a, int k) {
        partition(a, k, 0, a.length - 1);
    }

    private static void partition(int[] a, int k, int low, int high) {
        if (low >= high) {
            return;
        }
        while (low < high && a[low] < k) {
            low++;
        }
        // a[low] >= k OR low == high
        while (low < high && a[high] > k) {
            high--;
        }
        // a[high] <= k OR low == high
        swap(a, low, high);
        partition(a, k, low, high - 1);
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
