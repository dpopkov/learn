package learn.ijpds2nd.ch07arrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

public class E0719Sorted {
    public interface NotSortedPredicate {
        boolean test(int prev, int current);
    }

    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int[] a = in.requestIntArray("Enter list: ");
        boolean sorted = new E0719Sorted().isSorted(a, (p, c) -> p < c);
        System.out.printf("The list is %s sorted%n", sorted ? "already" : "not");
    }

    public boolean isSorted(int[] a, NotSortedPredicate notSortedPredicate) {
        for (int i = 1; i < a.length; i++) {
            if (notSortedPredicate.test(a[i - 1], a[i])) {
                return false;
            }
        }
        return true;
    }
}
