package learn.ijpds.ch12exceptions.exercises;

import learn.ijpds.ch07arrays.exercises.E0735Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Game hangman. Rewrite Exercise 7.35. The program reads the
 * words stored in a text file named hangman.txt. Words are delimited by spaces.
 */
public class E1217Hangman {
    public static void main(String[] args) {
        String fileName = "io/text/hangman.txt";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }
        try {
            List<String> words = readWords(file);
            new E0735Hangman(words).run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readWords(File file) throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()) {
                words.add(scanner.next());
            }
        }
        return words;
    }
}
