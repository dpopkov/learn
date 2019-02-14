package learn.core2.ch02io.random;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataIO {
    /**
     * Writes the specified number of characters, starting at the beginning of the string.
     * If length of the string is less than the specified size
     * then the method pads the string using zero values.
     * @param s string to write
     * @param fixedSize fixed number of characters to write
     * @param out data output
     * @throws IOException if an I/O error occurs
     */
    public static void writeFixedString(String s, int fixedSize, DataOutput out) throws IOException {
        for (int i = 0; i < fixedSize; i++) {
            char ch = 0;
            if (i < s.length()) {
                ch = s.charAt(i);
            }
            out.writeChar(ch);
        }
    }

    /**
     * Reads characters from the input stream until it has consumed the specified amount
     * of characters or until it encounters a zero value.
     * @param fixedSize fixed number of characters to read
     * @param in input stream
     * @return string of length not greater than the fixed size
     * @throws IOException if I/O error occurs
     */
    public static String readFixedString(int fixedSize, DataInput in) throws IOException {
        char[] chars = new char[fixedSize];
        int i = 0;
        while (i < fixedSize) {
            char ch = in.readChar();
            i++;
            if (ch == 0) {
                break;
            }
            chars[i] = ch;
        }
        in.skipBytes(2 * (fixedSize - i));
        return new String(chars, 0, i);
    }
}
