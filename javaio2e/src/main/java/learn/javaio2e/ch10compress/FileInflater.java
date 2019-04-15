package learn.javaio2e.ch10compress;

import learn.javaio2e.ch03in.StreamCopier;

import java.io.*;
import java.util.zip.InflaterInputStream;

import static learn.javaio2e.ch10compress.DirectDeflater.DEFLATE_SUFFIX;
import static learn.javaio2e.ch10compress.DirectInflater.INFLATE_SUFFIX;

public class FileInflater {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java FileInflater file1 [file2...]");
            return;
        }
        for (String fileName : args) {
            if (!fileName.endsWith(DEFLATE_SUFFIX)) {
                System.err.println(fileName + " does not appear to be a deflated file.");
                continue;
            }
            String outName = fileName.substring(0, fileName.length() - DEFLATE_SUFFIX.length()) + INFLATE_SUFFIX;
            try (InflaterInputStream fin = new InflaterInputStream(
                    new BufferedInputStream(new FileInputStream(fileName)));
                 OutputStream out = new BufferedOutputStream(new FileOutputStream(outName))) {
                StreamCopier.copy(fin, out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
