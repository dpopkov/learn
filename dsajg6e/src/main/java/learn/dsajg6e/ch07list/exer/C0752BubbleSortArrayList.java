package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.ArrayList;

public class C0752BubbleSortArrayList {
    static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        int last = list.size() - 1;
        for (int i = 0; i < last; i++) {
            for (int j = 0; j < last - i; j++) {
                E current = list.get(j);
                E next = list.get(j + 1);
                if (current.compareTo(next) > 0) {
                    swap(list, j, j + 1);
                }
            }
        }
    }

    private static <E extends Comparable<E>> void swap(ArrayList<E> list, int j, int i) {
        E tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
