package learn.ijpds.ch07arrays.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Hangman game that randomly generates a word and prompts the user
 * to guess one letter at a time.
 */
public class E0735Hangman {
    private static final String[] WORDS = {"write", "game", "random", "generate",
            "prompt", "letter", "display", "correct", "finish", "continue", "declare"};
    private static final char NOT_GUESSED = '*';

    private List<String> words;
    private Random random = new Random();
    private Scanner in = new Scanner(System.in);

    public E0735Hangman(List<String> words) {
        this.words = words;
    }

    public void run() {
        do {
            String word = words.get(random.nextInt(words.size()));
            char[] letters = new char[word.length()];
            Arrays.fill(letters, NOT_GUESSED);
            int missCount = 0;
            while (isNotComplete(letters)) {
                System.out.printf("(Guess) Enter a letter in word %s > ", String.valueOf(letters));
                String line = in.nextLine();
                if (line.isEmpty()) {
                    System.out.println("Enter a character.");
                    continue;
                }
                char letter = line.charAt(0);
                if (findLetter(letters, letter) > -1) {
                    System.out.println("     " + letter + " is already in the word");
                    continue;
                }
                if (!characterInWord(letter, word, letters)) {
                    missCount++;
                }
            }
            System.out.printf("The word is %s. You missed %d times%n", word, missCount);
            System.out.print("Do you want to guess another word? (y/n): ");
        } while ("y".equals(in.nextLine()));
    }

    public static void main(String[] args) {
        E0735Hangman hangman = new E0735Hangman(Arrays.asList(WORDS));
        hangman.run();
    }

    /**
     * Tries to find the specified character in the word and puts found characters into
     * array of letters.
     * @param ch letter
     * @param word word to find the character in
     * @param letters array of word letters
     * @return true if character was found in word, false otherwise
     */
    private static boolean characterInWord(char ch, String word, char[] letters) {
        boolean found = false;
        for (int start = 0, index;
                 start < word.length() && (index = word.indexOf(ch, start)) >= 0;
                 start = index + 1) {
            found = true;
            letters[index] = ch;
        }
        return found;
    }

    private static boolean isNotComplete(char[] letters) {
        boolean notComplete = false;
        for (char c : letters) {
            if (c == NOT_GUESSED) {
                notComplete = true;
                break;
            }
        }
        return notComplete;
    }

    private static int findLetter(char[] letters, char ch) {
        int r = -1;
        for (int i = 0; i < letters.length; i++) {
            if (ch == letters[i]) {
                r = i;
                break;
            }
        }
        return r;
    }
}
