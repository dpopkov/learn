package learn.bj6e.ch11io.exer;

import learn.bj6e.common.CmdTools;

import java.io.*;
import java.util.Optional;

/**
 * Asks the user for a file name and prints the number of characters,
 * words, and lines in that file.
 */
public class E1107CountWords {
    public static void main(String[] args) {
        String filename = "pom.xml";
        Optional<String> selected = CmdTools.getFileName(args);
        if (selected.isPresent()) {
            filename = selected.get();
        } else {
            System.out.println("Failed to get a filename. Use default name: " + filename);
        }
        int chars = 0;
        int words = 0;
        int lines = 0;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            int ch, prev = -1;
            while ((ch = in.read()) != -1) {
                chars++;
                if (Character.isAlphabetic(ch) && !Character.isAlphabetic(prev)) {
                    words++;
                } else if (ch == '\n') {
                    lines++;
                }
                prev = ch;
            }
            if (prev != '\n') {
                lines++;
            }
            System.out.println("lineCount = " + lines);
            System.out.println("wordCount = " + words);
            System.out.println("charCount = " + chars);
        } catch (IOException e) {
            System.out.println("I/O error: e");
        }
    }
}
