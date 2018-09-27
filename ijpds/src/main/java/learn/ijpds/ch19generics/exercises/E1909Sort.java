package learn.ijpds.ch19generics.exercises;

import java.util.Arrays;
import java.util.List;

public class E1909Sort {
    static <E extends Comparable<E>> void sort(List<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int j = i + 1;
            E current = list.get(j), prev;
            while (j > 0
                    && (prev = list.get(j - 1)).compareTo(current) > 0) {
                list.set(j, prev);
                j--;
            }
            list.set(j, current);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 7, 11, 5, 1, 13, 2, 17, 6);
        System.out.println(list);
        sort(list);
        System.out.println(list);
    }
}
