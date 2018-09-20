package learn.ijpds.ch12exceptions.exercises;

import learn.csia.utils.CliAppArgs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Write a method int readInFile(String line, File file) that returns the position number
 * of a line in the file filename or −1 if there is no such line or file.
 */
public class E1214FindInFile {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter text file name", "Enter line of text");
        String sourceName = in.nextString();
        String line = in.nextString();
        File file = new File(sourceName);
        int result = readInFile(line, file);
        System.out.println("result = " + result);
    }

    public static int readInFile(String line, File file) {
        int result = -1;
        if (!file.exists()) {
            return result;
        }
        int number = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String current = scanner.nextLine();
                number++;
                if (line.equals(current)) {
                    result = number;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            assert false : "File's existence is checked.";
            e.printStackTrace();
        }
        return result;
    }
}
