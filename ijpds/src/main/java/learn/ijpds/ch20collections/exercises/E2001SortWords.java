/* 20.1
Write a program that reads words from a text file and displays all the words in descending alphabetical order.
 */
package learn.ijpds.ch20collections.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E2001SortWords {
    public static void main(String[] args) {
        File file = new File("io/text/words.txt");
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(words);
        words.sort(Collections.reverseOrder());
        System.out.println(words);
    }
}
