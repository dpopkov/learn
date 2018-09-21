package learn.ijpds.ch07arrays.exercises;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Hangman game that randomly generates a word and prompts the user
 * to guess one letter at a time.
 */
public class E0735Hangman {
    private static final String[] WORDS = {"write", "game", "random", "generate",
            "prompt", "letter", "display", "correct", "finish", "continue", "declare"};

    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        do {
            String word = WORDS[random.nextInt(WORDS.length)];
            char[] letters = new char[word.length()];
            Arrays.fill(letters, '*');
            boolean running = true;
            boolean missed;
            int missCount = 0;
            while (running) {
                System.out.printf("(Guess) Enter a letter in word %s > ", String.valueOf(letters));
                char ch = in.nextLine().charAt(0);
                int idx = findLetter(letters, ch);
                if (idx > -1) {
                    System.out.println("     " + ch + " is already in the word");
                } else {
                    missed = true;
                    for (int start = 0;
                             start < word.length() && (idx = word.indexOf(ch, start)) >= 0;
                             start = idx + 1) {
                        missed = false;
                        letters[idx] = ch;
                    }
                    if (missed) {
                        missCount++;
                    }
                    running = !isComplete(letters);
                }
            }
            System.out.printf("The word is %s. You missed %d time%n", word, missCount);
            System.out.print("Do you want to guess another word? (y/n): ");
        } while ("y".equals(in.nextLine()));
    }

    private static boolean isComplete(char[] letters) {
        boolean complete = true;
        for (char c : letters) {
            if (c == '*') {
                complete = false;
                break;
            }
        }
        return complete;
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
