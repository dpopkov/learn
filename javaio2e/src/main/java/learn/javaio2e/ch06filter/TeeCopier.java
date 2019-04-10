package learn.javaio2e.ch06filter;

import java.io.*;

/**
 * Copies a file into two separate new files.
 */
public class TeeCopier {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.err.println("Usage: java TeeCopier infile outfile1 outfile2");
            return;
        }
        try (InputStream from = new BufferedInputStream(new FileInputStream(args[0]));
             OutputStream out1 = new BufferedOutputStream(new FileOutputStream(args[1]));
             OutputStream out2 = new BufferedOutputStream(new FileOutputStream(args[2]))) {
            OutputStream teeOut = new TeeOutputStream(out1, out2);
            byte[] bytes = new byte[1024];
            int n;
            while ((n = from.read(bytes)) != -1) {
                teeOut.write(bytes, 0, n);
            }
        }
    }
}
