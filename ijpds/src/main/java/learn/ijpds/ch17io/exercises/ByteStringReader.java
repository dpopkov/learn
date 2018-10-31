package learn.ijpds.ch17io.exercises;

/**
 * Base class for converting string representation of bytes to real bytes.
 */
public abstract class ByteStringReader {
    /**
     * Converts string of coded bytes to array of bytes
     * @param byteString string of bytes coded in some number system (bin, hex) separated with space or new line
     * @return array of bytes
     */
    public byte[] read(String byteString) {
        String[] tokens = byteString.split("\\s+");
        byte[] bytes = new byte[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            bytes[i] = parseByte(tokens[i]);
        }
        return bytes;
    }

    public abstract byte parseByte(String codedByte);
}
