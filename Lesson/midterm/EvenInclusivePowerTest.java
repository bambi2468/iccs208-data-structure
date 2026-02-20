import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class EvenInclusivePowerTest {
    @Test
    void testCountWithSmallBaseReturnsZero() {
        // Bases less than 6 cannot possibly have 5 distinct digits
        // in their 6th power (e.g., 5^6 = 15625).
        assertEquals(0, EvenInclusivePower.countEvenInclusivesUpTo(0),
                "Count should be 0 for base 0");

        assertEquals(0, EvenInclusivePower.countEvenInclusivesUpTo(5),
                "Count should be 0 for base 5");
    }

    @Test
    void testFindKthWithInvalidKReturnsNotFound() {
        // Testing the fallback return value (-1) for invalid inputs
        assertEquals(-1, EvenInclusivePower.findKthEvenInclusive(0),
                "0th item should return -1");

        assertEquals(-1, EvenInclusivePower.findKthEvenInclusive(-5),
                "Negative k should return -1");
    }

    @Test
    void testConsistencyBetweenMethods() {
        // Property-Based Test:
        // If we find the 10th Even-Inclusive number (let's call it X),
        // then counting up to X MUST return exactly 10.
        int k = 10;
        int kthNumber = EvenInclusivePower.findKthEvenInclusive(k);

        // Ensure it actually found a number
        assertTrue(kthNumber > 0, "Should find a valid k-th number");

        // The count up to that number must equal k
        int count = EvenInclusivePower.countEvenInclusivesUpTo(kthNumber);
        assertEquals(k, count,
                "Count up to the " + k + "th number should be exactly " + k);
    }

    @Test
    void testStrictBoundaryConsistency() {
        // If X is the 5th Even-Inclusive number, then counting up to X-1
        // should return exactly 4.
        int k = 5;
        int kthNumber = EvenInclusivePower.findKthEvenInclusive(k);
        int countBelow = EvenInclusivePower.countEvenInclusivesUpTo(kthNumber - 1);

        assertEquals(k - 1, countBelow,
                "Count up to (kth number - 1) should be k - 1");
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testPerformanceForLargeCount() {
        // Ensures the algorithm is efficient enough to process
        // up to base 500 within 2 seconds.
        int result = EvenInclusivePower.countEvenInclusivesUpTo(500);

        // We don't assert the exact number here, just that it completes
        // successfully without timing out and returns a non-negative count.
        assertTrue(result >= 0, "Result should be successfully calculated");
    }
}