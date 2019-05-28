package learn.dsajg6e.ch01primer.exer;

import learn.dsajg6e.tools.Input;

import java.util.Arrays;

public class R0108Vowels {
    public static void main(String[] args) {
        String w = Input.next("Enter a word: ");
        int v = countVowels(w);
        System.out.printf("Contains %d vowels%n", v);
    }

    private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    static {
        Arrays.sort(VOWELS);
    }

    private static int countVowels(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = Arrays.binarySearch(VOWELS, s.charAt(i));
            if (idx >= 0) {
                total++;
            }
        }
        return total;
    }
}
