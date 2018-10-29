package learn.ijpds.tools;

/**
 * Contains utility methods for working with bits.
 */
public class BitsTools {
    /**
     * Shifts all bytes in the array to the right by the specified
     * number of bits.
     * @param bytes array of bytes
     * @param shift number of bits
     */
    public static void shiftRight(byte[] bytes, int shift) {
        shiftRight(bytes, shift, bytes.length);
    }

    /**
     * Shifts {@code length} bytes in the array to the right by the specified
     * number of bits.
     * @param bytes array of bytes
     * @param shift number of bits
     * @param length number ob bytes to shift
     */
    public static void shiftRight(byte[] bytes, int shift, int length) {
        int mask = fillRightIntMask(Byte.SIZE);
        int prevShift = Byte.SIZE - shift;
        for (int i = length - 1; i > 0; i--) {
            int prev = bytes[i - 1] << prevShift;
            int current = (bytes[i] & mask) >>> shift;
            bytes[i] = (byte) (prev | current);
        }
        bytes[0] = (byte) ((bytes[0] & mask) >>> shift);
    }

    /**
     * Creates a bit mask of 1.
     * @param length number of 1-bits
     * @return bit mask
     */
    public static int fillRightIntMask(int length) {
        int mask = 0;
        for (int i = 0; i < length; i++) {
            mask = mask << 1;
            mask |= 1;
        }
        return mask;
    }

    /**
     * Converts byte to string as to sequence 8 bits of 1 and 0.
     * @param b byte value
     * @return string representation of byte
     */
    public static String toBinary(byte b) {
        StringBuilder builder = new StringBuilder(Byte.SIZE);
        int mask = 1 << (Byte.SIZE - 1);
        for (int i = 0; i < Byte.SIZE; i++) {
            builder.append((b & mask) == mask ? '1' : '0');
            mask >>= 1;
        }
        return builder.toString();
    }
}
