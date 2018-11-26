package learn.core1.ch08generics.restrictions;

import java.util.function.IntFunction;

public class HowToCreateGenericArray {
    /**
     * This method produces {@code ClassCastException} in runtime because array Object[]
     * cannot be cast to array Comparable[].
     */
    @SuppressWarnings({"unchecked", "unused"})
    @SafeVarargs
    public static <T extends Comparable<T>> T[] minMaxBad(T... elements) {
        Object[] result = new Object[2];
        result[0] = elements[0];
        result[1] = elements[0];
        return (T[]) result;
    }

    @SuppressWarnings({"Duplicates", "unchecked"})
    public static <T extends Comparable<T>> T[] minMax(IntFunction<T[]> constructor, T... elements) {
        T[] result = constructor.apply(2);
        T min = elements[0];
        T max = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (min.compareTo(elements[i]) > 0) {
                min = elements[i];
            }
            if (max.compareTo(elements[i]) < 0) {
                max = elements[i];
            }
        }
        result[0] = min;
        result[1] = max;
        return result;
    }

    public static void main(String[] args) {
        String[] mm = minMax(String[]::new,"b", "a", "c", "d");
        System.out.println("mm[0] = " + mm[0]);
        System.out.println("mm[1] = " + mm[1]);
    }
}
