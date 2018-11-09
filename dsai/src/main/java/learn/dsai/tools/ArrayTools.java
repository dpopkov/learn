package learn.dsai.tools;

import java.util.StringJoiner;

@SuppressWarnings("unused")
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
}
