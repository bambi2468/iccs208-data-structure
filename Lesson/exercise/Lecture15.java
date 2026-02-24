package exercise;
import java.util.Comparator;

public class Lecture15<T extends Comparable<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }

    static <T> void insertionSort(T[] array, Comparator<T> cc) {
        if (array.length <= 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            T insertVal = array[i];
            int j = i - 1;
            while (j >= 0 && cc.compare(array[j], insertVal) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertVal;
        }
    }

    static <T> void quickSort(T[] array, Comparator<T> cc){

    }
}