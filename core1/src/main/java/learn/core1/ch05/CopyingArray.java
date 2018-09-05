package learn.core1.ch05;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Demonstrates the use of reflection for manipulating arrays.
 */
public class CopyingArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int newLength = Math.random() < 0.99 ? 10 : 11;
        a = (int[]) goodCopyOf(a, newLength);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, newLength);
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an exception");
        try {
            b = (String[]) badCopyOf(b, newLength);
            System.out.println(Arrays.toString(b));
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    private static Object[] badCopyOf(Object[] a, int newLength) {
        Object[] destination = new Object[newLength];
        System.arraycopy(a, 0, destination, 0, Math.min(a.length, newLength));
        return destination;
    }

    /**
     * Grows an array by allocating a new array of the same type
     * and copying all elements.
     * @param source array to grow. Source array can be an object
     *               array or a primitive type array.
     * @param newLength length of the new array
     * @return a larger array that contains all elements of source
     */
    @SuppressWarnings("SuspiciousSystemArraycopy")
    public static Object goodCopyOf(Object source, int newLength) {
        Class clazz = source.getClass();
        if (!clazz.isArray()) {
            return null;
        }
        Class type = clazz.getComponentType();
        Object destination = Array.newInstance(type, newLength);
        System.arraycopy(source, 0, destination, 0, Math.min(Array.getLength(source), newLength));
        return destination;
    }

}
