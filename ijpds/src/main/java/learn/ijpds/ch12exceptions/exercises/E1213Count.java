package learn.ijpds.ch12exceptions.exercises;

import learn.csia.utils.CliAppArgs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 12.13 Count characters, words, and lines in a file.
 */
public class E1213Count {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter text file name");
        String sourceName = in.nextString();
        File file = new File(sourceName);
        if (!file.exists()) {
            System.out.println("File " + sourceName + " does not exist.");
            return;
        }
        int lines = 0;
        int words = 0;
        int chars = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines++;
                String[] wordArray = line.split("\\s+");
                words += wordArray.length;
                chars += line.length() + System.lineSeparator().length();
            }
            System.out.printf("%d lines, %d words, %d characters%n", lines, words, chars);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
