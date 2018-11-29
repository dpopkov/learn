package learn.dsai.ch06rec.merge;

import java.util.Arrays;

public class MergeSortApp {
    public static void main(String[] args) {
        long[] values = {64, 21, 33, 70, 12, 85, 44, 3, 99, 0, 108, 36};
        System.out.println(Arrays.toString(values));
        MergeSort ms = new MergeSort(values);
        ms.sort();
        System.out.println(Arrays.toString(values));
    }
}
