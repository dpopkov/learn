package learn.ijpds2nd.ch07arrays;

import learn.ijpds2nd.ch06methods.RandomCharacter;

/* Listing 7.4 */
public class CountLettersInArray {
    public static void main(String[] args) {
        char[] chars = createArray();
        System.out.println("The lowercase letters are");
        displayArray(chars);
        System.out.println();
        int[] counts = countLetters(chars);
        System.out.println("The occurrences of each letter are:");
        displayCounts(counts);
    }

    private static char[] createArray() {
        char[] chars = new char[100];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = RandomCharacter.getRandomLowerCaseLetter();
        }
        return chars;
    }

    private static void displayArray(char[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static int[] countLetters(char[] a) {
        int[] counts = new int[26];
        for (char c : a) {
            counts[c - 'a']++;
        }
        return counts;
    }

    private static void displayCounts(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            System.out.print(counts[i] + " " + (char)(i + 'a') + "  ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}
