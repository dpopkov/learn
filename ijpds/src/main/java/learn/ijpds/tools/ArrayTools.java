package learn.ijpds.tools;

public class ArrayTools {
    /**
     * Gets array of all input element except element at specified index.
     * @param a input array
     * @param i index of element to exclude
     * @return array of elements except the specified one
     */
    public static int[] without(int[] a, int i) {
        int[] rst = new int[a.length - 1];
        System.arraycopy(a, 0, rst, 0, i);
        System.arraycopy(a, i + 1, rst, i, a.length - i - 1);
        return rst;
    }

    /**
     * Creates a new array with value inserted as fist element.
     * @param a input array
     * @param value value to insert
     * @return augmented array
     */
    public static int[] insertAtStart(int[] a, int value) {
        int[] rst = new int[a.length + 1];
        rst[0] = value;
        System.arraycopy(a, 0, rst, 1, a.length);
        return rst;
    }
}
