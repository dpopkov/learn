package learn.dsajg6e.tools;

import java.util.Arrays;

/**
 * Contains utility methods for array manipulations.
 */
public class ArrayTools {

    /**
     * Tries to find the specified character in the array before the boundary index.
     * @param chars array of characters
     * @param bound boundary index in array
     * @param c character to find
     * @return index of the found character or -1
     */
    public static int find(char[] chars, int bound, char c) {
        for (int i = 0; i < bound; i++) {
            if (chars[i] == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Deletes one char element at the specified index.
     * @param charArray source array that remains intact
     * @param index index of the element to delete
     * @return array of chars containing all elements except the deleted by index
     */
    public static char[] deleteChar(char[] charArray, int index) {
        char[] result = new char[charArray.length - 1];
        for (int i = 0, j = 0; i < result.length; j++) {
            if (j != index) {
                result[i] = charArray[j];
                i++;
            }
        }
        return result;
    }

    /**
     * Splits the array into two sub-arrays beginning with the specified index.
     * @param array source array
     * @param splitIndex index of the first element in the second sub-array
     * @return array of 2 sub-arrays
     */
    public static int[][] split(int[] array, int splitIndex) {
        int[] head = Arrays.copyOfRange(array, 0, splitIndex);
        int[] tail = Arrays.copyOfRange(array, splitIndex, array.length);
        int[][] result = new int[2][];
        result[0] = head;
        result[1] = tail;
        return result;
    }

    public static boolean allEven(int[] a) {
        for (int i : a) {
            if (i % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean allOdd(int[] a) {
        for (int i : a) {
            if (i % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
