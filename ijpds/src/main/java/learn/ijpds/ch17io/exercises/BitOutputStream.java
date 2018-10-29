package learn.ijpds.ch17io.exercises;

import learn.ijpds.tools.BitsTools;

import java.io.*;

/**
 * Writes bits to an output stream.
 */
public class BitOutputStream implements AutoCloseable {
    /** Maximum amount of bytes that can be written. */
    private static final int BUFFER_SIZE = 128;

    private OutputStream output;
    private int currentByte;
    private int bitCount;
    private int byteCount;
    private byte[] buffer = new byte[BUFFER_SIZE];

    public BitOutputStream(OutputStream output) {
        this.output = output;
    }

    public BitOutputStream(File outputFile) throws FileNotFoundException {
        this.output = new BufferedOutputStream(new FileOutputStream(outputFile));
    }

    /**
     * Writes bit '0' or '1' to the output stream.
     * @param bit bit value as char '0' or '1'
     */
    public void writeBit(char bit) {
        int byteValue = bit - '0';
        currentByte = (currentByte << 1) | byteValue;
        bitCount++;
        if (bitCount == Byte.SIZE) {
            if (byteCount == BUFFER_SIZE - 1) {
                throw new RuntimeException("Byte buffer is full");
            }
            buffer[byteCount++] = (byte) currentByte;
            currentByte = 0;
            bitCount = 0;
        }
    }

    /**
     * Writes a string of bits to the output stream.
     * @param bits string of bits
     */
    public void writeBits(String bits) {
        for (int i = 0; i < bits.length(); i++) {
            writeBit(bits.charAt(i));
        }
    }

    @Override
    public void close() throws IOException {
        if (output != null) {
            if (bitCount != 0) {
                if (byteCount == 0) {
                    buffer[byteCount++] = (byte) currentByte;
                } else {
                    int shiftLength = Byte.SIZE - bitCount;
                    currentByte = currentByte << shiftLength;
                    buffer[byteCount++] = (byte) currentByte;
                    BitsTools.shiftRight(buffer, shiftLength, byteCount);
                }
            }
            output.write(buffer, 0, byteCount);
            output.close();
        }
    }
}
