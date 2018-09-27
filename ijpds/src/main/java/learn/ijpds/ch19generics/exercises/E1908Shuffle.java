package learn.ijpds.ch19generics.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class E1908Shuffle {
    static <E> void shuffle(ArrayList<E> list) {
        Random r = new Random();
        for (int i = list.size() - 1; i > 0; i--) {
            int j = r.nextInt(i);
            E t = list.get(i);
            list.set(i, list.get(j));
            list.set(j, t);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(list);
        shuffle(list);
        System.out.println(list);
    }
}
