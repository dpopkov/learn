package learn.javaio2e.ch20readerswriters;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Reads all files named on the command line and copies them to System.out,
 * prefixing each line with its line number.
 */
public class LineCat {
    public static void main(String[] args) {
        String line;
        for (String fileName : args) {
            try (LineNumberReader br = new LineNumberReader(new FileReader(fileName))) {
                while ((line = br.readLine()) != null) {
                    System.out.printf("%02d:%s%n", br.getLineNumber(), line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
