package learn.ijpds2nd.ch03select.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0313PalindromeTest {

    @Test
    public void testIsPalindrome() {
        assertTrue(E0313Palindrome.isPalindrome(111));
        assertTrue(E0313Palindrome.isPalindrome(11011));
        assertTrue(E0313Palindrome.isPalindrome(110011));
        assertTrue(E0313Palindrome.isPalindrome(191));
        assertFalse(E0313Palindrome.isPalindrome(193));
    }
}