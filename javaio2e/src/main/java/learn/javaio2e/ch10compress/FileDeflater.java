package learn.javaio2e.ch10compress;

import learn.javaio2e.ch03in.StreamCopier;

import java.io.*;
import java.util.zip.DeflaterOutputStream;

import static learn.javaio2e.ch10compress.DirectDeflater.DEFLATE_SUFFIX;

public class FileDeflater {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java FileDeflater file1 [file2...]");
            return;
        }
        for (String fileName : args) {
            String outName = fileName + DEFLATE_SUFFIX;
            try (InputStream in = new BufferedInputStream(new FileInputStream(fileName));
                 DeflaterOutputStream def = new DeflaterOutputStream(
                         new BufferedOutputStream(new FileOutputStream(outName)))) {
                StreamCopier.copy(in, def);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
