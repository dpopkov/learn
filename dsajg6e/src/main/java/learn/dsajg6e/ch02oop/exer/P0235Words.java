package learn.dsajg6e.ch02oop.exer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * P-2.35
 * Inputs a list of words, separated by whitespace, and outputs
 * how many times each word appears in the list.
 */
public class P0235Words {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "io/words.txt";
        if (args.length == 1) {
            filename = args[0];
        }
        List<String> words = new ArrayList<>();
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("[,.]?\\s+|\\.");
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        }
        Map<String, Long> stats = new TreeMap<>();
        for (String w : words) {
            stats.merge(w, 1L, (old, newValue) -> old + 1L);
        }
        stats.forEach((k, v) -> System.out.printf("%10s : %d%n", k, v));
    }
}
