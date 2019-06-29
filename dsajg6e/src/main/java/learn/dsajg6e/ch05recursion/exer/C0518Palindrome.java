package learn.dsajg6e.ch05recursion.exer;

public class C0518Palindrome {
    static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int lastIndex = s.length() - 1;
        if (s.charAt(0) != s.charAt(lastIndex)) {
            return false;
        }
        return isPalindrome(s.substring(1, lastIndex));
    }
}
