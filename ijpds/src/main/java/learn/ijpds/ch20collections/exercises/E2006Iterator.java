package learn.ijpds.ch20collections.exercises;

import learn.csia.utils.Stopwatch;

import java.util.ArrayList;
import java.util.Iterator;

public class E2006Iterator {
    @SuppressWarnings({"WhileLoopReplaceableByForEach", "ForLoopReplaceableByForEach"})
    public static void main(String[] args) {
        final int MAXIMUM = 10_000_000;
        Stopwatch sw = new Stopwatch();
        sw.start();
        ArrayList<Integer> list = new ArrayList<>(MAXIMUM);
        for (int i = 1; i <= MAXIMUM; i++) {
            list.add(i);
        }
        System.out.printf("Initializing: %d ms%n", sw.stop());

        System.out.println("Search using get(index)...");
        sw.start();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == MAXIMUM) {
                System.out.println("value found");
                break;
            }
        }
        System.out.printf("elapsed %d ms%n", sw.stop());

        System.out.println("Search using iterator...");
        sw.start();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == MAXIMUM) {
                System.out.println("value found");
                break;
            }
        }
        System.out.printf("elapsed %d ms%n", sw.stop());
    }
}
