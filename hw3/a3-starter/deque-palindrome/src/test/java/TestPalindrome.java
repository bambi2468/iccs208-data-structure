
/** IMPORTANT: Uncomment this file after you're done with the Deque interface and wordToDeque 
 **/
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("abba"));
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome(null));
        assertFalse(palindrome.isPalindrome("abab"));
        assertFalse(palindrome.isPalindrome("ba"));
    }

    @Test
    public void testIsPalindromeOffByOne() {
        OffByOne obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("ab", obo));
        // assertTrue(palindrome.isPalindrome("aba", obo));
        assertTrue(palindrome.isPalindrome("a", obo));
        assertTrue(palindrome.isPalindrome("", obo));
        // assertFalse(palindrome.isPalindrome(null, obo));
        // assertFalse(palindrome.isPalindrome("abab", obo));
        // assertFalse(palindrome.isPalindrome("ba", obo));
    }
}
