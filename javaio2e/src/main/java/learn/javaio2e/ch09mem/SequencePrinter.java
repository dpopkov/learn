package learn.javaio2e.ch09mem;

import learn.javaio2e.ch03in.StreamCopier;

import java.io.*;
import java.util.Vector;

/**
 * Reads a series of filenames, creates a sequence input stream.
 */
public class SequencePrinter {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: java SequencePrinter file1 [file2...]");
        }
        Vector<InputStream> streams = new Vector<>();
        for (String arg : args) {
            InputStream in = new BufferedInputStream(new FileInputStream(arg));
            streams.add(in);
        }
        InputStream in = new SequenceInputStream(streams.elements());
        StreamCopier.copy(in, System.out, true);
    }
}
