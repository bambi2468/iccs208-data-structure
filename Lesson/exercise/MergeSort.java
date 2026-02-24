package exercise;
import java.util.Comparator;

public class MergeSort {

    /**
     * Sorts the given array using the Merge Sort algorithm and a custom Comparator.
     */
    public static <T> void mergeSort(T[] array, Comparator<T> cc) {
        if (array == null || array.length <= 1) {
            return; // Base case: arrays of size 0 or 1 are already sorted.
        }
        
        // Create an auxiliary array once to use throughout the sorting process.
        // Due to Java's type erasure with generics, we instantiate an Object[] 
        // and typecast it to T[]. 
        @SuppressWarnings("unchecked")
        T[] aux = (T[]) new Object[array.length];
        
        // Call the recursive helper method
        mergeSortHelper(array, aux, 0, array.length - 1, cc);
    }

    /**
     * Recursive helper method to divide the array.
     */
    private static <T> void mergeSortHelper(T[] array, T[] aux, int low, int high, Comparator<T> cc) {
        if (low >= high) {
            return;
        }
        
        int mid = low + (high - low) / 2;
        
        // Sort the left half
        mergeSortHelper(array, aux, low, mid, cc);
        
        // Sort the right half
        mergeSortHelper(array, aux, mid + 1, high, cc);
        
        // Merge the two sorted halves
        merge(array, aux, low, mid, high, cc);
    }

    /**
     * Merges two sorted sub-arrays back together.
     */
    private static <T> void merge(T[] array, T[] aux, int low, int mid, int high, Comparator<T> cc) {
        // Copy the current segment into the auxiliary array
        for (int k = low; k <= high; k++) {
            aux[k] = array[k];
        }

        int i = low;       // Pointer for the left half
        int j = mid + 1;   // Pointer for the right half

        // Traverse the auxiliary array and place the smallest elements back into the main array
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                // Left half is exhausted, take from the right
                array[k] = aux[j++];
            } else if (j > high) {
                // Right half is exhausted, take from the left
                array[k] = aux[i++];
            } else if (cc.compare(aux[j], aux[i]) < 0) {
                // The element on the right is strictly smaller than the element on the left
                array[k] = aux[j++];
            } else {
                // The element on the left is smaller or equal (maintains sorting stability)
                array[k] = aux[i++];
            }
        }
    }
}