package learn.javaio2e.ch17files;

import learn.javaio2e.ch03in.StreamCopier;

import java.io.*;

/**
 * Uses canonical path to test whether two files are the same before copying.
 */
public class SafeFileCopier {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java " + SafeFileCopier.class.getName() + " infile outfile");
            return;
        }
        File inFile = new File(args[0]);
        File outFile = new File(args[1]);
        if (inFile.getCanonicalPath().equals(outFile.getCanonicalPath())) {
            System.out.println("Source and destination files are the same.");
            return;
        }
        try (InputStream in = new BufferedInputStream(new FileInputStream(inFile));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))) {
            StreamCopier.copy(in, out);
            System.out.printf("%s copied to %s%n", inFile, outFile);
        }
    }
}
