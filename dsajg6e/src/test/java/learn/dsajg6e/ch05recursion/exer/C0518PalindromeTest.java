package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class C0518PalindromeTest {

    @Test
    public void testIsPalindrome() {
        assertTrue(C0518Palindrome.isPalindrome("racecar"));
        assertFalse(C0518Palindrome.isPalindrome("racecaz"));
    }
}
