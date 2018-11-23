package learn.dsai.ch05.adt.sorted;

import java.util.Arrays;

public class ListInsertionSort {
    public static void main(String[] args) {
        int size = 10;
        long[] data = new long[size];
        for (int i = 0; i < data.length; i++) {
            data[i] = (long) (Math.random() * 100);
        }
        System.out.println("Unsorted:");
        System.out.println(Arrays.toString(data));

        SortedList list = new SortedList();
        for (long v : data) {
            list.insert(v);
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = list.remove();
        }

        System.out.println("Sorted:");
        System.out.println(Arrays.toString(data));
    }
}
