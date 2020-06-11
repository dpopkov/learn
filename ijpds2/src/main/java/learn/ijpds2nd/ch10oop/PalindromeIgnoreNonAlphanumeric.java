package learn.ijpds2nd.ch10oop;

import learn.ijpds2nd.tools.ConsoleInput;

/* Listing 10.10 */
public class PalindromeIgnoreNonAlphanumeric {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        String s = in.requestLine("Enter a string: ");
        System.out.printf("Ignoring non-alphanumeric characters,%nis %s a palindrome? %s%n", s, isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        String filtered = filter(s);
        String reversed = reverse(filtered);
        return filtered.equals(reversed);
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String filter(String s) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }
}
