import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TripleUppercaseTest {
    @Test
    void testAllLowercaseReturnsFalse() {
        assertFalse(
                TripleUppercase.hasTripleUppercase("abc"),
                "All lowercase should return false");
    }

    @Test
    void testTwoConsecutiveUppercaseReturnsFalse() {
        assertFalse(
                TripleUppercase.hasTripleUppercase("abCDef"),
                "Only two consecutive uppercase => false");
    }

    @Test
    void testThreeConsecutiveUppercaseInMiddle() {
        assertTrue(
                TripleUppercase.hasTripleUppercase("abCDEf"),
                "Three consecutive uppercase in middle");
    }

    @Test
    void testEntireStringIsThreeUppercase() {
        assertTrue(
                TripleUppercase.hasTripleUppercase("WOW"),
                "Exactly three uppercase letters");
    }

    @Test
    void testMultipleGroupsWithOneTriple() {
        assertTrue(
                TripleUppercase.hasTripleUppercase("HeLLoWORLD"),
                "At least one group of 3+ uppercase");
    }

    @Test
    void testSpacesSeparatingUppercase() {
        assertFalse(
                TripleUppercase.hasTripleUppercase("A B C"),
                "Spaces should break the streak");
    }

    @Test
    void testNullReturnsFalse() {
        assertFalse(
                TripleUppercase.hasTripleUppercase(null),
                "Null input should return false");
    }

    @Test
    void testEmptyStringReturnsFalse() {
        assertFalse(
                TripleUppercase.hasTripleUppercase(""),
                "Empty string should return false");
    }

    @Test
    void testSingleCharacterReturnsFalse() {
        assertFalse(
                TripleUppercase.hasTripleUppercase("A"),
                "Single character should return false");
    }

    @Test
    void testTwoCharacterStringReturnsFalse() {
        assertFalse(
                TripleUppercase.hasTripleUppercase("AB"),
                "Two characters => too short");
    }

    @Test
    void testTripleAtStart() {
        assertTrue(
                TripleUppercase.hasTripleUppercase("ABCdef"),
                "Triple uppercase at the start");
    }

    @Test
    void testTripleAtEnd() {
        assertTrue(
                TripleUppercase.hasTripleUppercase("defABC"),
                "Triple uppercase at the end");
    }

    @Test
    void testMoreThanThreeConsecutive() {
        assertTrue(
                TripleUppercase.hasTripleUppercase("aABCDEFg"),
                "More than three consecutive");
    }

    @Test
    void testDigitsBreakStreak() {
        assertFalse(
                TripleUppercase.hasTripleUppercase("AB1CD"),
                "Digits should break the streak");
    }

    @Test
    void testSpecialCharsBreakStreak() {
        assertFalse(
                TripleUppercase.hasTripleUppercase("AB!CD"),
                "Special chars should break streak");
    }

    @Test
    void testAllUppercase() {
        assertTrue(
                TripleUppercase.hasTripleUppercase("ABCDEFG"),
                "All uppercase should return true");
    }

    @Test
    void testUppercaseMixedWithDigits() {
        assertFalse(
                TripleUppercase.hasTripleUppercase("A1B2C3"),
                "Uppercase separated by digits");
    }
}
