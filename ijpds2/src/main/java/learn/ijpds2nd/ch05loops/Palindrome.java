package learn.ijpds2nd.ch05loops;

import java.util.Scanner;

/* Listing 5.14 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = in.nextLine();
        boolean r = isPalindrome(word);
        System.out.printf("Word '%s' %s%n", word, r ? "is palindrome" : "is not a palindrome");
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ch1 = Character.toLowerCase(s.charAt(i));
            if (ch1 == ' ') {
                i++;
                continue;
            }
            char ch2 = Character.toLowerCase(s.charAt(j));
            if (ch2 == ' ') {
                j--;
                continue;
            }
            if (ch1 != ch2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
