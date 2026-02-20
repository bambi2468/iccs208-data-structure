import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TripleCheckerTest {
    private final TripleChecker<Integer> intChecker = new TripleChecker<>();
    private final TripleChecker<Character> charChecker = new TripleChecker<>();
    private final TripleChecker<String> strChecker = new TripleChecker<>();

    // --- Null / empty edge cases ---

    @Test
    void testNullItemsReturnsFalse() {
        assertFalse(
                intChecker.hasTriple(null, n -> true),
                "Null items should return false");
    }

    @Test
    void testNullConditionReturnsFalse() {
        assertFalse(
                intChecker.hasTriple(List.of(1, 2, 3), null),
                "Null condition should return false");
    }

    @Test
    void testEmptyListReturnsFalse() {
        assertFalse(
                intChecker.hasTriple(
                        Collections.emptyList(), n -> true),
                "Empty list should return false");
    }

    // --- Below threshold ---

    @Test
    void testTwoMatchesReturnsFalse() {
        assertFalse(
                intChecker.hasTriple(
                        List.of(2, 4, 1), n -> n % 2 == 0),
                "Only two consecutive matches => false");
    }

    @Test
    void testOneElementReturnsFalse() {
        assertFalse(
                intChecker.hasTriple(
                        List.of(5), n -> true),
                "Single element => false");
    }

    @Test
    void testTwoElementsReturnsFalse() {
        assertFalse(
                intChecker.hasTriple(
                        List.of(5, 5), n -> true),
                "Two elements => false");
    }

    // --- Triple found ---

    @Test
    void testExactlyThreeMatches() {
        assertTrue(
                intChecker.hasTriple(
                        List.of(2, 4, 6), n -> n % 2 == 0),
                "Exactly three even numbers in a row");
    }

    @Test
    void testTripleInMiddle() {
        assertTrue(
                intChecker.hasTriple(
                        List.of(1, 2, 4, 6, 1),
                        n -> n % 2 == 0),
                "Triple even in the middle");
    }

    @Test
    void testTripleAtStart() {
        assertTrue(
                intChecker.hasTriple(
                        List.of(2, 4, 6, 1, 3),
                        n -> n % 2 == 0),
                "Triple even at the start");
    }

    @Test
    void testTripleAtEnd() {
        assertTrue(
                intChecker.hasTriple(
                        List.of(1, 3, 2, 4, 6),
                        n -> n % 2 == 0),
                "Triple even at the end");
    }

    @Test
    void testMoreThanThreeConsecutive() {
        assertTrue(
                intChecker.hasTriple(
                        List.of(2, 4, 6, 8, 10),
                        n -> n % 2 == 0),
                "Five consecutive matches => true");
    }

    // --- Streak broken ---

    @Test
    void testStreakBrokenThenRebuilt() {
        assertTrue(
                intChecker.hasTriple(
                        List.of(2, 4, 1, 2, 4, 6),
                        n -> n % 2 == 0),
                "Streak broken and later rebuilt to 3");
    }

    @Test
    void testNoMatchAtAll() {
        assertFalse(
                intChecker.hasTriple(
                        List.of(1, 3, 5, 7),
                        n -> n % 2 == 0),
                "No even numbers at all => false");
    }

    // --- Generic type: Character ---

    @Test
    void testCharacterUppercaseTriple() {
        assertTrue(
                charChecker.hasTriple(
                        Arrays.asList('a', 'B', 'C', 'D', 'e'),
                        Character::isUpperCase),
                "Three consecutive uppercase chars");
    }

    @Test
    void testCharacterUppercaseNoTriple() {
        assertFalse(
                charChecker.hasTriple(
                        Arrays.asList('a', 'B', 'C', 'd', 'E'),
                        Character::isUpperCase),
                "Only two consecutive uppercase chars");
    }

    // --- Generic type: String ---

    @Test
    void testStringLengthTriple() {
        assertTrue(
                strChecker.hasTriple(
                        List.of("hi", "cats", "dogs", "bats"),
                        s -> s.length() == 4),
                "Three consecutive length-4 strings");
    }

    @Test
    void testStringLengthNoTriple() {
        assertFalse(
                strChecker.hasTriple(
                        List.of("cat", "dog", "hi", "bat"),
                        s -> s.length() == 3),
                "Streak broken by 'hi'");
    }

    // --- Condition always true / always false ---

    @Test
    void testAlwaysTrueWithThreeElements() {
        assertTrue(
                intChecker.hasTriple(
                        List.of(1, 2, 3), n -> true),
                "Always-true predicate with 3 items");
    }

    @Test
    void testAlwaysFalseReturnsFalse() {
        assertFalse(
                intChecker.hasTriple(
                        List.of(1, 2, 3, 4, 5), n -> false),
                "Always-false predicate => false");
    }
}
