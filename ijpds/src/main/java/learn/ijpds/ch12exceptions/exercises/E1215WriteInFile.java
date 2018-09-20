package learn.ijpds.ch12exceptions.exercises;

import learn.csia.utils.CliAppArgs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * (Writing in a sorted file) Write a method public static int
 * writeInFile(String name, File file) that writes name at its correct
 * position in sorted file. The method returns the line position.
 */
public class E1215WriteInFile {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter text file name", "Enter line to insert");
        String sourceName = in.nextString();
        String line = in.nextString();
        File file = new File(sourceName);
        try {
            int position = writeInFile(line, file);
            System.out.println("Inserted at position " + position);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int writeInFile(String line, File file) throws FileNotFoundException {
        if (!file.exists()) {
            return -1;
        }
        List<String> lines = new ArrayList<>();
        int position = -1;
        try (Scanner scanner = new Scanner(file)) {
            boolean inSearch = true;
            while (scanner.hasNextLine()) {
                String current = scanner.nextLine();
                if (inSearch) {
                    position++;
                    if (current.compareTo(line) > 0) {
                        lines.add(line);
                        inSearch = false;
                    }
                }
                lines.add(current);
            }
        }
        try (PrintWriter out = new PrintWriter(file)) {
            for (String s : lines) {
                out.println(s);
            }
        }
        return position;
    }
}
