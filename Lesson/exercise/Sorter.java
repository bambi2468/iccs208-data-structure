package exercise;
import java.util.Comparator;

public class Sorter {

    /**
     * Sorts the given array using the Insertion Sort algorithm and a custom Comparator.
     */
    public static <T> void insertionSort(T[] array, Comparator<T> cc) {
        if (array == null || array.length <= 1) {
            return; // Base case: arrays of 0 or 1 element are already sorted.
        }

        // Iterate through the array starting from the second element
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1] that are greater than the key
            // to one position ahead of their current position.
            while (j >= 0 && cc.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            
            // Insert the key into its correct position
            array[j + 1] = key;
        }
    }
}