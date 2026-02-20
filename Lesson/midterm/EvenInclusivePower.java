import java.math.BigInteger;

public class EvenInclusivePower {

    // --- Configuration Constants ---

    // The exponent we are raising the base number to
    private static final int POWER = 6;

    // The lowest possible base that mathematically could have enough digits
    private static final int MIN_SEARCH_BASE = 6;

    // -------------------------------

    /**
     * Counts the number of Even-Inclusive numbers up to a given maximum base.
     * * @param maxBase The upper bound of the base number to check.
     * 
     * @return The total count of Even-Inclusive numbers found.
     */
    public static int countEvenInclusivesUpTo(int maxBase) {
        int count = 0;
        int base = MIN_SEARCH_BASE;
        while (base <= maxBase) {
            if (isEvenInclusive(base)) {
                count++;
            }
            base++;
        }
        return count;
    }

    /**
     * Finds the k-th Even-Inclusive number.
     * * @param k The position (1-based index) of the number to find.
     * 
     * @return The k-th Even-Inclusive base number, or -1 if not found.
     */
    public static int findKthEvenInclusive(int k) {
        int count = 0;
        int base = MIN_SEARCH_BASE;
        while (count < k) {
            if (isEvenInclusive(base)) {
                count++;
            }
            base++;
        }
        return base;
    }

    /**
     * Helper method to determine if a number is Even-Inclusive.
     * * @param n The base number to check.
     * 
     * @return true if n^6 contains 0, 2, 4, 6, and 8; false otherwise.
     */
    private static boolean isEvenInclusive(int n) {
        BigInteger val = BigInteger.valueOf(n);
        val = val.pow(POWER);
        String valStr = val.toString();
        String[] arr = { "0", "2", "4", "6", "8" };
        for (String ed : arr) {
            if (!valStr.contains(ed)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // You can use these print statements to test your code
        System.out.println("Even-Inclusive numbers up to 500: "
                + countEvenInclusivesUpTo(500));

        System.out.println("Even-Inclusive numbers up to 1000: "
                + countEvenInclusivesUpTo(1000));

        System.out.println("The 50th Even-Inclusive number is: "
                + findKthEvenInclusive(50));

        System.out.println("The 100th Even-Inclusive number is: "
                + findKthEvenInclusive(100));
    }
}