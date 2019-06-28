package learn.dsajg6e.tools;

/**
 * Contains utility methods for array manipulations.
 */
public class ArrayTools {
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
}
