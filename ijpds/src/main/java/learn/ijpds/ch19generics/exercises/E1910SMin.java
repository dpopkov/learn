package learn.ijpds.ch19generics.exercises;

import java.util.Arrays;
import java.util.List;

public class E1910SMin {
    static <E extends Comparable<E>> E min(List<E> list) {
        E m = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            E e = list.get(i);
            if (e.compareTo(m) < 0) {
                m = e;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, -1, 4);
        System.out.println(min(list));
    }
}
