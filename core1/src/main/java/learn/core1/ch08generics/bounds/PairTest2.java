/* 8.2 */
package learn.core1.ch08generics.bounds;

import learn.core1.ch08generics.Pair;

import java.time.LocalDate;

public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
            LocalDate.of(1906, 12, 9), // G. Hopper
            LocalDate.of(1815, 12, 10), // A. Lovelace
            LocalDate.of(1903, 12, 3), // J. von Neumann
            LocalDate.of(1910, 6, 22), // K. Zuse
        };

        Pair<LocalDate> mm = minMax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }

    @SuppressWarnings("Duplicates")
    @SafeVarargs
    private static <T extends Comparable<? super T>> Pair<T> minMax(T... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        T min = values[0];
        T max = values[0];
        for (int i = 1; i < values.length; i++) {
            T value = values[i];
            if (max.compareTo(value) < 0) {
                max = value;
            }
            if (min.compareTo(value) > 0) {
                min = value;
            }
        }
        return new Pair<>(min, max);
    }
}
