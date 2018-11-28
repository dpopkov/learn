/* Listing 6.2 */
package learn.dsai.ch06rec;

import java.util.Scanner;

/**
 * Creates anagrams
 */
public class AnagramApp {
    private static char[] chars;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = in.nextLine();
        chars = input.toCharArray();
        doAnagram(input.length());
    }

    private static void doAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int j = 0; j < newSize; j++) {
            doAnagram(newSize - 1);
            if (newSize == 2) {
                displayWord();
            }
            rotate(newSize);
        }
    }

    private static void rotate(int newSize) {
        int position = chars.length - newSize;
        char tmp = chars[position];
        int j;
        for (j = position + 1; j < chars.length; j++) {
            chars[j - 1] = chars[j];
        }
        chars[j - 1] = tmp;
    }

    private static void displayWord() {
        System.out.println(chars);
    }
}
