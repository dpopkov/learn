package learn.dsajg6e.ch12sortselect;

import java.util.Comparator;

public class QuickSortInPlace {
    public static <K> void quickSort(K[] s, Comparator<K> comp, int a, int b) {
        if (a >= b) {
            return; // subarray is trivially sorted
        }
        int left = a;
        int right = b - 1;
        K pivot = s[b];
        while (left <= right) {
            while (left <= right && comp.compare(s[left], pivot) < 0) {
                left++;
            }
            // post-condition: left > right OR s[left] >= pivot
            while (left <= right && comp.compare(pivot, s[right]) < 0) {
                right--;
            }
            // post-condition: left > right OR pivot >= s[right]
            if (left <= right) {
                swap(s, left, right);
                left++;
                right--;
            }
        }
        swap(s, left, b);   // put pivot into its final place (currently marked by left index)
        quickSort(s, comp, a, left - 1);
        quickSort(s, comp, left + 1, b);
    }

    private static <K> void swap(K[] s, int i, int j) {
        K temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
