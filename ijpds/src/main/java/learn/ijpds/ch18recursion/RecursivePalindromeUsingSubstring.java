/* 18.3 */
package learn.ijpds.ch18recursion;

public class RecursivePalindromeUsingSubstring {
    private static int count;

    public static boolean isPalindrome(String s) {
        count++;
        if (s.length() < 2) {
            return true;
        } else {
            int last = s.length() - 1;
            if (s.charAt(0) != s.charAt(last)) {
                return false;
            } else {
                return isPalindrome(s.substring(1, last));
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"moon", "noon", "a", "aba", "ab"};
        for (String word : words) {
            count = 0;
            System.out.printf("Is '%s' a palindrome? %s%n", word, isPalindrome(word) ? "Yes" : "No");
            System.out.println("count = " + count);
        }
    }
}
