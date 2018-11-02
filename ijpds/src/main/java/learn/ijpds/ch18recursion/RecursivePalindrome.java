/* 18.4 */
package learn.ijpds.ch18recursion;

public class RecursivePalindrome {
    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    private static boolean isPalindrome(String s, int low, int high) {
        if (low >= high) {
            return true;
        } else if (s.charAt(low) != s.charAt(high)) {
            return false;
        }
        return isPalindrome(s, low + 1, high - 1);
    }

    @SuppressWarnings("unused")
    private static boolean isPalindromeNonRecursive(String s) {
        for (int low = 0, high = s.length() - 1;
                low < high;
                low++, high--) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        String[] words = {"moon", "noon", "a", "aba", "ab", "abdxcxdba"};
        for (String word : words) {
            System.out.printf("Is '%s' a palindrome? %s%n", word, isPalindrome(word) ? "Yes" : "No");
        }
    }
}
