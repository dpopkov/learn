package learn.javaio2e.ch11jar;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/**
 * A revised version of the {@code FancyZipLister}.
 * It works with JAR files and prints the attributes of each entry.
 */
public class JarLister {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java JarLister jar-file");
            return;
        }
        JarFile jarFile = new JarFile(args[0]);
        Enumeration<JarEntry> jarEntries = jarFile.entries();
        while (jarEntries.hasMoreElements()) {
            JarEntry entry = jarEntries.nextElement();
            String name = entry.getName();
            Date lastModified = new Date(entry.getTime());
            long uncompressedSize = entry.getSize();
            long compressedSize = entry.getCompressedSize();
            long crc = entry.getCrc();
            int method = entry.getMethod();
            String comment = entry.getComment();
            if (method == ZipEntry.STORED) {
                System.out.println(name + " was stored at " + lastModified);
                System.out.println("with a size of " + uncompressedSize + " bytes");
            } else if (method == ZipEntry.DEFLATED) {
                System.out.println(name + " was deflated at " + lastModified);
                printSavings(uncompressedSize, compressedSize);
            } else {
                System.out.println(name + " was compressed using an unrecognized method at " + lastModified);
                printSavings(uncompressedSize, compressedSize);
            }
            System.out.println("Its CRC is " + crc);
            if (comment != null && !comment.isEmpty()) {
                System.out.println(comment);
            }
            if (entry.isDirectory()) {
                System.out.println(name + " is a directory");
            }
            Attributes a = entry.getAttributes();
            if (a != null) {
                a.entrySet().forEach(System.out::println);
            }
            System.out.println();
        }
    }

    private static void printSavings(long uncompressedSize, long compressedSize) {
        System.out.println("from " + uncompressedSize + " bytes to "
                + compressedSize + " bytes, a savings of "
                + (100.0 - 100.0 * compressedSize / uncompressedSize) + "%");
    }
}
