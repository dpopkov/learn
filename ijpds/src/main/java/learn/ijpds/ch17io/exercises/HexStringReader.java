package learn.ijpds.ch17io.exercises;

/**
 * Converts binary strings of '0' and '1' to bytes.
 */
public class HexStringReader extends ByteStringReader {
    @Override
    public byte parseByte(String codedByte) {
        if (codedByte.length() > 2) {
            throw new IllegalArgumentException("Byte cannot contains more that 2 hex digits: " + codedByte);
        }
        return (byte) Integer.parseInt(codedByte, 16);
    }
}
