package learn.ijpds2nd.ch07arrays.exer;

import java.util.Arrays;
import java.util.Scanner;

public class E0735Hangman {
    private static final String[] WORDS = {"write", "game", "that",
            "random", "generate", "word", "prompt", "user", "guess", "letter",
            "present", "sample", "display", "asterisk", "finish", "number",
            "continue", "play", "array"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playing = true;
        while (playing) {
            String word = getRandom();
            char[] displayBuffer = new char[word.length()];
            Arrays.fill(displayBuffer, '*');
            boolean guessing = true;
            int missed = 0;
            while (guessing) {
                System.out.printf("(Guess) Enter a letter in word %s > ", new String(displayBuffer));
                char ch = in.nextLine().charAt(0);
                if (containsChar(displayBuffer, ch)) {
                    System.out.printf("\t%c is already in the word%n", ch);
                } else {
                    boolean found = setAtAllPlaces(displayBuffer, ch, word);
                    if (found) {
                        if (word.equals(new String(displayBuffer))) {
                            System.out.printf("The word is \"%s\". You missed %d %s%n",
                                    word, missed, missed == 1 ? "time" : "times");
                            guessing = false;
                        }
                    } else {
                        System.out.printf("\t%c is not in the word%n", ch);
                        missed++;
                    }
                }
            }
            System.out.print("Do you want to guess another word? Enter y or n ");
            char answer = in.nextLine().charAt(0);
            if ('n' == answer) {
                playing = false;
            }
        }
    }

    private static boolean setAtAllPlaces(char[] buffer, char ch, String word) {
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (ch == word.charAt(i)) {
                buffer[i] = ch;
                found = true;
            }
        }
        return found;
    }

    private static boolean containsChar(char[] chars, char ch) {
        for (char c : chars) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }

    private static String getRandom() {
        return WORDS[(int) (Math.random() * WORDS.length)];
    }
}
