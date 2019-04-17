package learn.javaio2e.ch10compress.zip;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Prints information about the files in a zip archive.
 */
public class FancyZipLister {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java FancyZipLister zip-file1 [zip-file2...]");
            return;
        }
        for (String fileName : args) {
            try (ZipFile zipFile = new ZipFile(fileName)) {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry entry = entries.nextElement();
                    printEntry(entry);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printEntry(ZipEntry entry) {
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
        } else {
            String savingsMsg = "from " + uncompressedSize + " bytes to "
                    + compressedSize + " bytes, a savings of "
                    + (100.0 - 100.0 * compressedSize / uncompressedSize) + "%";
            if (method == ZipEntry.DEFLATED) {
                System.out.println(name + " was deflated at " + lastModified);
                System.out.println(savingsMsg);
            } else {
                System.out.println(name + " was compressed using an unrecognized method at " + lastModified);
                System.out.println(savingsMsg);
            }
        }
        System.out.println("Its CRC is " + crc);
        if (comment != null && !comment.isEmpty()) {
            System.out.println(comment);
        }
        if (entry.isDirectory()) {
            System.out.println(name + " is a directory");
        }
        System.out.println();
    }
}
