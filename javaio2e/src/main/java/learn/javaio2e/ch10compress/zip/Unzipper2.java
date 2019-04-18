package learn.javaio2e.ch10compress.zip;

import learn.javaio2e.ch03in.StreamCopier;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * An alternative unzipper that uses a {@code ZipInputStream} instead of a {@code ZipFile}.
 */
public class Unzipper2 {
    public static void main(String[] args) throws IOException {
        for (String fileName : args) {
            try (ZipInputStream zipInput = new ZipInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
                ZipEntry zipEntry;
                while ((zipEntry = zipInput.getNextEntry()) != null) {
                    System.out.println("Unzipping " + zipEntry.getName());
                    try (OutputStream out = new BufferedOutputStream(new FileOutputStream(zipEntry.getName()))) {
                        StreamCopier.copy(zipInput, out);
                    }
                    zipInput.closeEntry();
                }
            }
        }
    }
}
