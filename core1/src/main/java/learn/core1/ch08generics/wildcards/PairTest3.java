/* 8.3 */
package learn.core1.ch08generics.wildcards;

import learn.core1.ch04.Employee;
import learn.core1.ch05.Manager;
import learn.core1.ch08generics.Pair;

public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy", 800_000, 2003, 12, 15);
        Manager cfo = new Manager("Sid Sneaky", 600_000, 2003, 12, 15);
        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1_000_000);
        cfo.setBonus(500_000);
        Manager[] managers = {ceo, cfo};

        Pair<Employee> result = new Pair<>();
        minMaxBonus(managers, result);
        System.out.println("fist: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());

        maxMinBonus(managers, result);
        System.out.println("fist: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
    }

    private static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies");
    }

    private static void minMaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0) {
            return;
        }
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max.getBonus() < a[i].getBonus()) {
                max = a[i];
            }
            if (min.getBonus() > a[i].getBonus()) {
                min = a[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    private static void maxMinBonus(Manager[] a, Pair<? super Manager> result) {
        minMaxBonus(a, result);
        PairAlg.swap(result);
    }
}

class PairAlg {
    @SuppressWarnings("unused")
    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p) {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}