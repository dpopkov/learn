package learn.dsajg6e.ch12sortselect;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSortArray {
    /** Merge contents of sorted arrays s1 and s2 into properly sized array s. */
    public static <K> void merge(K[] s1, K[] s2, K[] s, Comparator<K> comp) {
        int i = 0;
        int j = 0;
        while (i + j < s.length) {
            if (j == s2.length || (i < s1.length && comp.compare(s1[i], s2[j]) < 0)) {
                s[i + j] = s1[i++];
            } else {
                s[i + j] = s2[j++];
            }
        }
    }

    /** Merge-sort contents of array s. */
    public static <K> void mergeSort(K[] s, Comparator<K> comp) {
        int n = s.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        K[] s1 = Arrays.copyOfRange(s, 0, mid);
        K[] s2 = Arrays.copyOfRange(s, mid, n);
        mergeSort(s1, comp);
        mergeSort(s2, comp);
        merge(s1, s2, s, comp);
    }
}
