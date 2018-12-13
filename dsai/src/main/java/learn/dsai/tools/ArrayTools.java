package learn.dsai.tools;

import java.util.Random;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ArrayTools {

    public static <T> String toString(T[] array) {
        return toString(array, array.length);
    }

    public static <T> String toString(T[] array, int length) {
        return toString(array, length, ", ");
    }

    public static <T> String toString(T[] array, int length, String delimiter) {
        if (array == null) {
            return "null";
        }
        StringJoiner joiner = new StringJoiner(delimiter, "[", "]");
        /*StringBuilder builder = new StringBuilder();
        builder.append('[');*/
        for (int i = 0; i < length; i++) {
            joiner.add(array[i].toString());
            /*if (i > 0) {
                builder.append(delimiter);
            }
            builder.append(array[i]);*/
        }
//        builder.append(']');
        return joiner.toString();
    }

    public static void println(long[] array) {
        println(array, array.length);
    }

    public static void println(long[] array, int length) {
        System.out.println(toString(array, length));
    }

    public static String toString(long[] array) {
        return toString(array, array.length);
    }

    public static String toString(long[] array, int length) {
        if (array == null) {
            return "null";
        }
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                builder.append(", ");
            }
            builder.append(array[i]);
        }
        builder.append(']');
        return builder.toString();
    }

    public static int insert(long[] array, long... values) {
        int i;
        for (i = 0; i < values.length; i++) {
            array[i] = values[i];
        }
        return i;
    }

    /**
     * Checks whether the specified array is partitioned.
     * To partition data is to divide it into two groups, so that all the items with a key value higher than
     * a specified amount are in one group, and all the items with a lower key value are in another.
     * @param array checked array
     * @param rightPartStart starting index of right group
     * @return true if elements of the left group are not greater than elements of the right group,
     *          false otherwise
     */
    public static boolean isPartitioned(long[] array, int rightPartStart) {
        long leftMax = max(array, 0, rightPartStart);
        long rightMin = min(array, rightPartStart, array.length);
        return leftMax <= rightMin;
    }

    public static long max(long[] array, int from, int to) {
        long maxValue = array[from];
        for (int i = from + 1; i < to; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public static long min(long[] array, int from, int to) {
        long minValue = array[from];
        for (int i = from + 1; i < to; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    public static void shuffle(long[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + random.nextInt(array.length - i);
            long temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static boolean containSameElements(long[] a1, long[] a2) {
        Set<Long> set1 = LongStream.of(a1).boxed().collect(Collectors.toSet());
        Set<Long> set2 = LongStream.of(a2).boxed().collect(Collectors.toSet());
        return set1.equals(set2);
    }
}
