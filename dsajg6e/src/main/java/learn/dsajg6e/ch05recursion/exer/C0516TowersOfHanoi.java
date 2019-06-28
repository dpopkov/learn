package learn.dsajg6e.ch05recursion.exer;

import java.util.List;

public class C0516TowersOfHanoi {
    public static <T> void move(List<T> from, List<T> to, List<T> helper) {
        move(from, from.size(), to, helper);
    }

    private static <T> void move(List<T> from, int numItems, List<T> to, List<T> helper) {
        if (numItems > 1) {
            move(from, numItems - 1, helper, to);
        }
        T item = from.remove(from.size() - 1);
        to.add(item);
        if (numItems > 1) {
            move(helper, numItems - 1, to, from);
        }
    }
}
