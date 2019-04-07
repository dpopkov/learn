package learn.javaio2e.ch04files;

import learn.javaio2e.ch03in.StreamCopier;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Reads a filename from the command line, then copies the file to System.out.
 */
public class FileDumper {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java FileDumper filename");
            return;
        }
        typeFile(args[0]);
    }

    private static void typeFile(String filename) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(filename))) {
            StreamCopier.copy(in, System.out);
        }
    }
}
