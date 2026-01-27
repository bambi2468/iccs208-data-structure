import java.util.function.*;

interface HasIsLarger<T>{
    boolean isLarger(T a);
}

public class MaxDemo<T> {
    static <T> T maxValue(T[] items, BiFunction<T, T, Boolean> isLarger) {
        if (items.length == 0)
            return null;
        T maxVal = items[0];
        for (T t : items) {
            if (isLarger.apply(t, maxVal)) {
                maxVal = t;
            }
        }
        return maxVal;
    }

    static <T extends HasIsLarger<T>> T maxValue(T[] items) {
        if (items.length == 0)
            return null;
        T maxVal = items[0];
        for (T t : items) {
            if (t.isLarger(maxVal)) {
                maxVal = t;
            }
        }
        return maxVal;
    }
}