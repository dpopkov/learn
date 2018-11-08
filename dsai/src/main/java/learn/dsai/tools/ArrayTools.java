package learn.dsai.tools;

@SuppressWarnings("unused")
public class ArrayTools {

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
