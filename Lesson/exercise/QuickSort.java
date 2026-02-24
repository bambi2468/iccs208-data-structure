package exercise;
import java.util.Comparator;

public class QuickSort {

    /**
     * Sorts the given array using the Quick Sort algorithm and a custom Comparator.
     */
    public static <T> void quickSort(T[] array, Comparator<T> cc) {
        if (array == null || array.length <= 1) {
            return; // Base case: arrays of 0 or 1 element are already sorted.
        }
        quickSortHelper(array, 0, array.length - 1, cc);
    }

    /**
     * Recursive helper method that applies the divide and conquer strategy.
     */
    private static <T> void quickSortHelper(T[] array, int low, int high, Comparator<T> cc) {
        if (low < high) {
            // Partition the array around a pivot and get the pivot's final index
            int pivotIndex = partition(array, low, high, cc);
            
            // Recursively sort the elements before and after the partition
            quickSortHelper(array, low, pivotIndex - 1, cc);
            quickSortHelper(array, pivotIndex + 1, high, cc);
        }
    }

    /**
     * Partitions the sub-array. 
     * Elements smaller than or equal to the pivot are moved to the left of the pivot,
     * and elements greater are moved to the right.
     */
    private static <T> int partition(T[] array, int low, int high, Comparator<T> cc) {
        // Choosing the last element as the pivot
        T pivot = array[high];
        
        // Index of the smaller element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (cc.compare(array[j], pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        
        // Place the pivot in its correct sorted position
        swap(array, i + 1, high);
        return i + 1;
    }

    /**
     * Helper method to swap two elements in the array.
     */
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}