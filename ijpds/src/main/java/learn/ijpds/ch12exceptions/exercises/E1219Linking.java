package learn.ijpds.ch12exceptions.exercises;

import learn.csia.utils.CliAppArgs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Linking two files.
 * Write a program that prompts the user to enter the name of an author and the title of one their books.
 * It writes the author's name to a sorted file. The book's title is written at the end of Books.txt with
 * the line number of the author's name in Authors.txt.
 */
public class E1219Linking {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter author", "Enter book title");
        String author = in.nextString();
        String title = in.nextString();
        File authorFile = new File("io/text/Authors.txt");
        int position = -1;
        try {
            position = insert(author, authorFile);
            System.out.println("position = " + position);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        File titleFile = new File("io/text/Books.txt");
        try (FileOutputStream fos = new FileOutputStream(titleFile, true);
             PrintWriter out = new PrintWriter(fos)) {
            out.println(title + " " + position);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int insert(String author, File file) throws FileNotFoundException {
        if (!file.exists()) {
            try (PrintWriter out = new PrintWriter(file)) {
                out.println(author);
                return 0;
            }
        }
        List<String> lines = new ArrayList<>();
        int position = -1;
        boolean found = false;
        boolean inserted = false;
        try (Scanner scanner = new Scanner(file)) {
            while (!found && scanner.hasNextLine()) {
                String current = scanner.nextLine();
                if (!inserted) {
                    position++;
                    int compare = author.compareTo(current);
                    if (compare == 0) {
                        found = true;
                    } else if (compare < 0) {
                        lines.add(author);
                        inserted = true;
                    }
                }
                lines.add(current);
            }
        }
        if (!found) {
            if (!inserted) {
                lines.add(author);
                position = lines.size() - 1;
            }
            try (PrintWriter out = new PrintWriter(file)) {
                for (String line : lines) {
                    out.println(line);
                }
            }
        }
        return position;
    }
}
