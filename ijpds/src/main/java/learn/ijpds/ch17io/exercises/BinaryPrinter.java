package learn.ijpds.ch17io.exercises;

import java.util.function.Consumer;

/**
 * Prints data as sequence of bytes in binary representation.
 */
public class BinaryPrinter extends Printer {
    public BinaryPrinter(Consumer<String> output, int bytesPerLine) {
        super(output, bytesPerLine);
    }

    /**
     * Displays the bit representation for the last byte in an integer.
     * @param byteValue integer value of byte
     * @return bits of the last byte
     */
    @Override
    public String getByteRepresentation(int byteValue) {
        int mask = 0b10000000;
        char[] digits = new char[Byte.SIZE];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (byteValue & mask) == mask ? '1' : '0';
            mask >>>= 1;
        }
        return new String(digits);
    }
}
