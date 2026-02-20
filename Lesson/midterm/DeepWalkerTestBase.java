import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

abstract class DeepWalkerTestBase {
    abstract <T> Iterable<T> createWalker(List<List<T>> input);

    // Single non-empty row
    @Test
    void testSingleNonEmptyRow() {
        List<List<Integer>> input = List.of(List.of(2, 9));
        List<Integer> result = collectAll(createWalker(input));

        assertEquals(List.of(2, 9), result);
    }

    // Multiple rows with varying lengths
    @Test
    void testMultipleNonEmptyRows() {
        List<List<Integer>> input = List.of(
                List.of(4, 8),
                List.of(6),
                List.of(9, 2, 1));
        List<Integer> result = collectAll(createWalker(input));

        assertEquals(List.of(4, 8, 6, 9, 2, 1), result);
    }

    // Rows with empty rows mixed in
    @Test
    void testRowsWithEmptyRowsMixed() {
        List<List<Integer>> input = List.of(
                List.of(2, 8),
                List.of(),
                List.of(6),
                List.of(9, 1, 4),
                List.of(),
                List.of(3, 5, 7, 0));
        List<Integer> result = collectAll(createWalker(input));

        assertEquals(List.of(2, 8, 6, 9, 1, 4, 3, 5, 7, 0), result);
    }

    // Completely empty input
    @Test
    void testEmptyInput() {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> result = collectAll(createWalker(input));

        assertTrue(result.isEmpty(), "No elements for empty input");
    }

    // Input with only empty rows
    @Test
    void testOnlyEmptyRows() {
        List<List<Integer>> input = List.of(
                List.of(),
                List.of(),
                List.of());
        List<Integer> result = collectAll(createWalker(input));

        assertTrue(result.isEmpty(), "No elements when all rows empty");
    }

    // Null input handled gracefully
    @Test
    void testNullInput() {
        List<Integer> result = collectAll(createWalker(null));

        assertTrue(result.isEmpty(), "No elements for null input");
    }

    // next() throws when exhausted
    @Test
    void testNextThrowsWhenExhausted() {
        List<List<Integer>> input = List.of(List.of(7));
        Iterator<Integer> it = createWalker(input).iterator();

        it.next();
        assertThrows(NoSuchElementException.class, it::next);
    }

    // Null rows are skipped
    @Test
    void testNullRowsSkipped() {
        List<List<Integer>> input = new ArrayList<>(
                Arrays.asList(
                        List.of(3, 5),
                        null,
                        List.of(8),
                        null));
        List<Integer> result = collectAll(createWalker(input));

        assertEquals(List.of(3, 5, 8), result);
    }

    // Works with String type
    @Test
    void testWithStringType() {
        List<List<String>> input = List.of(
                List.of("a", "b"),
                List.of(),
                List.of("c"));
        List<String> result = collectAll(createWalker(input));

        assertEquals(List.of("a", "b", "c"), result);
    }

    private <T> List<T> collectAll(Iterable<T> iterable) {
        List<T> result = new ArrayList<>();
        for (T element : iterable) {
            result.add(element);
        }
        return result;
    }
}
