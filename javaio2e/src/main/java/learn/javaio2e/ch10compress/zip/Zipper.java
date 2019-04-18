package learn.javaio2e.ch10compress.zip;

import learn.javaio2e.ch03in.StreamCopier;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Uses a zip output stream chained to a file output stream to create a single zip archive
 * from a list of files named on the command line.
 * The name of the output zip file and the files to be stored i the archive are read
 * from the command line.
 * An optional -d command-line flag can set the level of compression anywhere from 0 to 9.
 */
public class Zipper {
    private static final int MAXIMUM_COMPRESSION = 9;

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            printUsage();
            return;
        }
        String outputFile = args[0];
        int level = MAXIMUM_COMPRESSION;
        int start = 1;
        if (args[0].equals("-d")) {
            try {
                level = Integer.parseInt(args[1]);
                outputFile = args[2];
                start = 3;
            } catch (Exception ex) {
                printUsage();
                return;
            }
        }
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outputFile))) {
            out.setLevel(level);
            for (int i = start; i < args.length; i++) {
                ZipEntry zipEntry = new ZipEntry(args[i]);
                try (InputStream in = new BufferedInputStream(new FileInputStream(args[i]))) {
                    System.out.println("Compressing " + args[i]);
                    out.putNextEntry(zipEntry);
                    StreamCopier.copy(in, out);
                }
            }
        }
    }

    private static void printUsage() {
        System.err.println("Usage: java Zipper [-d level] name.zip file1 [file2...]");
    }
}
