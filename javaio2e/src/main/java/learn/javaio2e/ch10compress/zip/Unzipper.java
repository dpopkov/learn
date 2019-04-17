package learn.javaio2e.ch10compress.zip;

import learn.javaio2e.ch03in.StreamCopier;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Simple unzip program that unpacks a zip archive named on the command line.
 */
public class Unzipper {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java Unzipper zip-file");
            return;
        }
        try (ZipFile zipFile = new ZipFile(args[0])) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                System.out.println("Unzipping " + entry.getName());
                try (OutputStream out = new BufferedOutputStream(new FileOutputStream(entry.getName()))) {
                    InputStream in = zipFile.getInputStream(entry);
                    StreamCopier.copy(in, out);
                }
            }
        }
    }
}
