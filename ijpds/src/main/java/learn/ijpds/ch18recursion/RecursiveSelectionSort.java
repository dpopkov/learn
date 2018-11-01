/* 18.5 */
package learn.ijpds.ch18recursion;

import java.util.Arrays;

public class RecursiveSelectionSort {
    public static void sort(double[] list) {
        sort(list, 0, list.length - 1);
    }

    private static void sort(double[] list, int low, int high) {
        if (low >= high) {
            return;
        }
        int iMin = low;
        double min = list[low];
        for (int i = low + 1; i <= high; i++) {
            if (list[iMin] > list[i]) {
                iMin = i;
                min = list[i];
            }
        }
        list[iMin] = list[low];
        list[low] = min;
        sort(list, low + 1, high);
    }

    public static void main(String[] args) {
        double[] values = {3, 1, 4, -3, 2, 7, -1, 3.14};
        sort(values);
        System.out.println(Arrays.toString(values));
    }
}
