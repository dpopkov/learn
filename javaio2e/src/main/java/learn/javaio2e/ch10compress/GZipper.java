package learn.javaio2e.ch10compress;

import learn.javaio2e.ch03in.StreamCopier;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Reads a list of files from the command line and gzips each one.
 */
public class GZipper {
    static final String GZIP_SUFFIX = ".gz";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java GZipper file1 [file2...]");
            return;
        }
        for (String fileName : args) {
            String outName = fileName + GZIP_SUFFIX;
            try (InputStream in = new BufferedInputStream(new FileInputStream(fileName));
                 GZIPOutputStream gzOut = new GZIPOutputStream(
                         new BufferedOutputStream(new FileOutputStream(outName)))) {
                StreamCopier.copy(in, gzOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
