package learn.javaio2e.ch10compress.zip;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Lists the entries in a zip file specified on the command line.
 */
public class ZipLister {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java ZipLister filename");
            return;
        }
        ZipFile zipFile = new ZipFile(args[0]);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            System.out.println(entries.nextElement());
        }
    }
}
