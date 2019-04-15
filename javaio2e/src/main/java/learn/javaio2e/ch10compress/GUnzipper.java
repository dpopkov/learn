package learn.javaio2e.ch10compress;

import learn.javaio2e.ch03in.StreamCopier;

import java.io.*;
import java.util.zip.GZIPInputStream;

import static learn.javaio2e.ch10compress.GZipper.GZIP_SUFFIX;

public class GUnzipper {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java GUnzipper file1 [file2...]");
            return;
        }
        for (String inName : args) {
            if (!inName.endsWith(GZIP_SUFFIX)) {
                System.err.println(inName + " does not appear to be a gzipped file.");
                continue;
            }
            String outName = inName.substring(0, inName.length() - GZIP_SUFFIX.length()) + ".gzunzipped";
            try (GZIPInputStream gzIn = new GZIPInputStream(
                    new BufferedInputStream(new FileInputStream(inName)));
                 OutputStream out = new BufferedOutputStream(new FileOutputStream(outName))) {
                StreamCopier.copy(gzIn, out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
