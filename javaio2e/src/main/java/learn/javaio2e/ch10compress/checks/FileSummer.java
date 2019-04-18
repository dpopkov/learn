package learn.javaio2e.ch10compress.checks;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/**
 * A simple program that calculates and prints a CRC-32 checksum for any file.
 */
public class FileSummer {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java FileSummer filename");
            return;
        }
        String fileName = args[0];
        try (InputStream in = new BufferedInputStream(new FileInputStream(fileName))) {
            System.out.println(fileName + ":\t" + calculateCRC(in));
        }
    }

    private static long calculateCRC(InputStream in) throws IOException {
        Checksum checksum = new CRC32();
        byte[] buf = new byte[512];
        int numBytes;
        while ((numBytes = in.read(buf)) != -1) {
            checksum.update(buf, 0, numBytes);
        }
        return checksum.getValue();
    }
}
