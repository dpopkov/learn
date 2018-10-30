package learn.ijpds.ch17io.exercises;

import java.io.*;

public class E1719ViewHex {
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    /**
     * Gets hex representation of the last byte in the specified integer.
     * @param byteValue byte value (last byte is used)
     * @return hex string
     */
    public static String getHex(int byteValue) {
        char[] digits = new char[2];
        digits[0] = HEX_DIGITS[(byteValue >>> 4) & 0b1111];
        digits[1] = HEX_DIGITS[byteValue & 0b1111];
        return new String(digits);
    }

    @SuppressWarnings("SameParameterValue")
    private static void printFileAsHex(File file, int bytesPerLine) throws IOException {
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file))) {
            for (int count = 1, byteValue; (byteValue = input.read()) != -1; count++) {
                System.out.print(getHex(byteValue));
                System.out.print((count % bytesPerLine == 0) ? System.lineSeparator() : " ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java " + E1719ViewHex.class.getName() + " source_file");
            System.exit(1);
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File does not exist: " + file.getAbsolutePath());
            System.exit(2);
        }
        printFileAsHex(file, 8);
    }
}
