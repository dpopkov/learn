package learn.javaio2e.ch02out;

import java.io.IOException;

/**
 * Constructs a byte array filled with an ASCII chart,
 * then blasts it onto the console in one call to write().
 */
public class AsciiArray {
    public static void main(String[] args) {
        final int start = 32;
        final int end = 127;
        int numSymbols = end - start + 1;
        byte[] b = new byte[numSymbols * 2];
        final byte linefeed = '\n';
        final byte tab = '\t';
        int index = 0;
        for (int i = start; i < end; i++) {
            b[index++] = (byte) i;
            b[index++] = i % 8 == 7 ? linefeed : tab;
        }
        b[index] = linefeed;
        try {
            System.out.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
