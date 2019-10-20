package learn.dsajg6e.ch10maps;

import learn.dsajg6e.ch09pq2.Entry;

import java.util.Scanner;

/**
 * A program that counts words in a document, printing the most frequent.
 */
public class WordCount {
    public static void main(String[] args) {
        Map<String, Integer> freq = new ChainHashMap<>();
        Scanner scanner = new Scanner(System.in).useDelimiter("[^a-zA-Z]");
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            Integer count = freq.get(word);
            if (count == null) {
                count = 0;
            }
            freq.put(word, count + 1);
            int maxCount = 0;
            String maxWord = "no word";
            for (Entry<String, Integer> e : freq.entrySet()) {
                if (e.getValue() > maxCount) {
                    maxWord = e.getKey();
                    maxCount = e.getValue();
                }
            }
            System.out.print("The most frequent word is '" + maxWord);
            System.out.println("' with " + maxCount + " occurrences");
        }
    }
}
