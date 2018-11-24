package learn.core1.ch08generics;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class ArrayAlg {
    @SafeVarargs
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    @SuppressWarnings("unused")
    public static <T extends Comparable<T>> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0) {
                smallest = a[i];
            }
        }
        return smallest;
    }

    /**
     * Gets the minimum and maximum of an array of objects of type T.
     * @param a an array of objects of type T
     * @param <T> type of objects in array
     * @return a pair with the min and max value, or null if a
     * is null or empty
     */
    public static <T extends Comparable<T>> Pair<T> minMax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            T current = a[i];
            if (min.compareTo(current) > 0) {
                min = current;
            }
            if (max.compareTo(current) < 0) {
                max = current;
            }
        }
        return new Pair<>(min, max);
    }

    public static void main(String[] args) {
        useGetMiddle();
//        useMinMax();
    }

    private static void useMinMax() {
        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9), // G. Hopper
                LocalDate.of(1815, 12, 10), // A. Lovelace
                LocalDate.of(1903, 12, 3), // J. von Neumann
                LocalDate.of(1910, 6, 22), // K. Zuse
        };
        Pair<ChronoLocalDate> mm = ArrayAlg.minMax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }

    @SuppressWarnings({"RedundantTypeArguments", "unused"})
    private static void useGetMiddle() {
        String middle = ArrayAlg.<String>getMiddle("John", "Q.", "Public");
        System.out.println("middle = " + middle);

        double middle2 = ArrayAlg.<Double>getMiddle(3.14, 1729.0, 0.0);
        System.out.println("middle2 = " + middle2);

        double middle3 = ArrayAlg.getMiddle(1.0, 2.0, 3.0);
        System.out.println("middle3 = " + middle3);

        int middle4 = ArrayAlg.getMiddle(1, 2, 3);
        System.out.println("middle4 = " + middle4);

        Number middle5 = ArrayAlg.getMiddle(1.0, 2, 3);
        System.out.println("middle5 = " + middle5);

        /* Use this type of error in order to see which type
        the compiler infers for a generic method call: */
//        String obj = ArrayAlg.getMiddle("Hello", 0, null);
        Comparable obj = ArrayAlg.getMiddle("Hello", 0, null);
        System.out.println(obj.getClass().getName());
    }
}
