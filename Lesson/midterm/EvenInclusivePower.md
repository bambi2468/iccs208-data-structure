## Problem: The "Even-Inclusive" Powers

**Background**
In number theory, analyzing the digits of large integer powers can reveal interesting patterns. For this assignment, you will be searching for a specific sequence of numbers known as **Even-Inclusive** numbers.

**Definition**
A positive integer  is defined as **Even-Inclusive** if its 6th power () contains **every even digit** (0, 2, 4, 6, and 8) at least once in its decimal representation.

For example, you will need to determine if  () contains a 0, 2, 4, 6, and 8. (It does not, as it is missing 0).

**Your Task**
You must complete the `EvenInclusivePower` class by implementing three methods:

1. `isEvenInclusive(int n)`: A helper method that calculates  and checks if it contains all five even digits.
2. `countEvenInclusivesUpTo(int maxBase)`: Calculates how many Even-Inclusive numbers exist where the base is between 6 and `maxBase` (inclusive).
3. `findKthEvenInclusive(int k)`: Finds the -th Even-Inclusive number in the sequence, starting the search from base 6.

**Hints & Constraints**

* **Large Numbers:** The 6th power of even relatively small integers will quickly exceed the maximum limit of standard Java `int` and `long` data types. You will need to use `java.math.BigInteger` to handle the arithmetic without overflow.
* **Starting Point:** The lowest possible base that can be Even-Inclusive is 6. This is because  is 15,625, which only has 5 digits and cannot possibly hold all 5 distinct even digits without excluding the odd ones present.
* **String Conversion:** Converting your large power to a `String` might be the easiest way to check for the presence of specific characters.

---

### Starter Code (Skeleton)

Provide the following skeleton to your students. It enforces the 80-character line limit and includes the requested constants and parameter names.

```java
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
     * @return The total count of Even-Inclusive numbers found.
     */
    public static int countEvenInclusivesUpTo(int maxBase) {
        // TODO: Implement this method
        return 0; 
    }
    
    /**
     * Finds the k-th Even-Inclusive number.
     * * @param k The position (1-based index) of the number to find.
     * @return The k-th Even-Inclusive base number, or -1 if not found.
     */
    public static int findKthEvenInclusive(int k) {
        // TODO: Implement this method
        return -1; 
    }
    
    /**
     * Helper method to determine if a number is Even-Inclusive.
     * * @param n The base number to check.
     * @return true if n^6 contains 0, 2, 4, 6, and 8; false otherwise.
     */
    private static boolean isEvenInclusive(int n) {
        // TODO: Implement this method (Hint: Use BigInteger)
        return false; 
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

```