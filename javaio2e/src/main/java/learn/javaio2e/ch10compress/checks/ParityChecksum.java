package learn.javaio2e.ch10compress.checks;

import java.util.zip.Checksum;

/**
 * The simplest checksum class that implements the parity algorithm.
 * Calculates a parity bit, 1 if the number of 1 bits is odd, 0 if the number of 1 bits is even.
 * This checksum is calculated by summing up the number of 1 bits and taking the remainder
 * when that sum is divided by two.
 * However, this scheme isn't very robust. It can detect single-bit errors, but in the face of bursts of errors,
 * as often occur in noisy connections, there's a 50-50 chance that corrupt data will be reported as correct.
 */
@SuppressWarnings("unused")
public class ParityChecksum implements Checksum {
    private long checksum = 0;

    @Override
    public void update(int b) {
        int numOneBits = 0;
        for (int i = 1; i < 256; i *= 2) {
            if ((b & i) != 0) {
                numOneBits++;
            }
        }
        checksum = (checksum + numOneBits) % 2;
    }

    @Override
    public void update(byte[] data, int off, int len) {
        for (int i = off; i < off + len; i++) {
            this.update(data[i]);
        }
    }

    @Override
    public long getValue() {
        return checksum;
    }

    @Override
    public void reset() {
        checksum = 0;
    }
}
