package learn.ijpds2nd.ch07arrays;

import java.util.Arrays;

/* Listing 7.8 */
public class SelectionSort {
    private interface SwapPredicate {
        boolean test(int a, int b);
    }

    public static void main(String[] args) {
        int[] a = {2, 9, 5, 4, 8, 1, 6};
        System.out.println("Array: " + Arrays.toString(a));
        System.out.println("Ascending sorting...");
        sort(a, (n1, n2) -> n1 > n2);
        System.out.println("Array: " + Arrays.toString(a));
        System.out.println("Descending sorting...");
        sort(a, (n1, n2) -> n1 < n2);
        System.out.println("Array: " + Arrays.toString(a));
    }

    private static void sort(int[] array, SwapPredicate pr) {
        for (int i = 0; i < array.length - 1; i++) {
            int swappingIdx = findIdxForSwapping(i, array, pr);
            if (i != swappingIdx) {
                swap(i, swappingIdx, array);
            }
        }
    }

    private static int findIdxForSwapping(int from, int[] array, SwapPredicate pr) {
        int idx = from;
        for (int i = from + 1; i < array.length; i++) {
            if (pr.test(array[idx], array[i])) {
                idx = i;
            }
        }
        return idx;
    }

    private static void swap(int i, int j, int[] array) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
