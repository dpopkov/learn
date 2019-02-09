package learn.bj6e.ch11io.exer;

import learn.bj6e.common.CmdTools;

import java.io.*;
import java.util.Optional;

/**
 * Reads a file containing text.
 * Reads each line and sends it to the output, preceded by line numbers.
 */
public class E1104NumberedLines {
    public static void main(String[] args) {
        String filename;
        Optional<String> selected = CmdTools.getFileName(args);
        if (selected.isPresent()) {
            filename = selected.get();
        } else {
            System.out.println("Failed to get a filename");
            return;
        }
        try (LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(filename)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = reader.getLineNumber();
                System.out.printf("/* %d */ %s%n", number, line);
            }
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }

    }
}
