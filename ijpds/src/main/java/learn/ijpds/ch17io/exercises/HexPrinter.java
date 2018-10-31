package learn.ijpds.ch17io.exercises;

import java.util.function.Consumer;

/**
 * Prints data as sequence of bytes in hexadecimal representation.
 */
public class HexPrinter extends Printer {
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    public HexPrinter(Consumer<String> output, int bytesPerLine) {
        super(output, bytesPerLine);
    }

    /**
     * Gets hex representation of the last byte in the specified integer.
     * @param byteValue byte value (last byte is used)
     * @return hex string
     */
    @Override
    public String getByteRepresentation(int byteValue) {
        char[] digits = new char[2];
        digits[0] = HEX_DIGITS[(byteValue >>> 4) & 0b1111];
        digits[1] = HEX_DIGITS[byteValue & 0b1111];
        return new String(digits);
    }
}
