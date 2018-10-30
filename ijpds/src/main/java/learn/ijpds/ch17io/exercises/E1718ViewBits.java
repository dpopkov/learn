/*
17.18 (739)
View bits.
 */
package learn.ijpds.ch17io.exercises;

import java.io.*;

public class E1718ViewBits {
    /**
     * Displays the bit representation for the last byte in an integer.
     * @param value integer
     * @return bits of the last byte
     */
    public static String getBits(int value) {
        int mask = 0b10000000;
        char[] digits = new char[Byte.SIZE];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (value & mask) == mask ? '1' : '0';
            mask >>>= 1;
        }
        return new String(digits);
    }

    @SuppressWarnings("SameParameterValue")
    private static void printFileAsBinary(File file, int bytesPerLine) throws IOException {
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file))) {
            for (int count = 1, byteValue; (byteValue = input.read()) != -1; count++) {
                System.out.print(getBits(byteValue));
                System.out.print(count % bytesPerLine == 0
                        ? System.lineSeparator()
                        : " ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java " + E1718ViewBits.class.getName() + " source_file");
            System.exit(1);
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File does not exist: " + file.getAbsolutePath());
            System.exit(2);
        }
        printFileAsBinary(file, 8);
    }
}
