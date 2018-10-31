package learn.ijpds.ch17io.exercises;

/**
 * Converts binary strings of '0' and '1' to bytes.
 */
public class BinaryStringReader extends ByteStringReader {
    @Override
    public byte parseByte(String codedByte) {
        if (codedByte.length() > Byte.SIZE) {
            throw new IllegalArgumentException("Byte cannot contains more that " + Byte.SIZE + " bits: " + codedByte);
        }
        return (byte) Integer.parseInt(codedByte, 2);
    }
}
