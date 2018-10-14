package learn.core1.ch08generics.wildcards;

import learn.core1.ch05.Manager;
import learn.core1.ch08generics.Pair;

public class SuperDemo {
    private static void minMaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0) {
            return;
        }
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) {
                min = a[i];
            }
            if (max.getBonus() < a[i].getBonus()) {
                max = a[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void main(String[] args) {
        Manager[] array = {
                new Manager("Bob", 200_000, 2000, 10, 1),
                new Manager("Alice", 100_000, 2000, 10, 1),
                new Manager("Bill", 300_000, 2000, 10, 1),
        };
        array[0].setBonus(350);
        array[1].setBonus(150);
        array[2].setBonus(250);

        Pair<Manager> result = new Pair<>();
        minMaxBonus(array, result);
        System.out.println("Minimum bonus: " + result.getFirst());
        System.out.println("Maximum bonus: " + result.getSecond());

        Pair<Object> result2 = new Pair<>();
        minMaxBonus(array, result2);
        System.out.println("Minimum bonus: " + result2.getFirst());
        System.out.println("Maximum bonus: " + result2.getSecond());
    }
}
