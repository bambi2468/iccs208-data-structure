package fns;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class BiFunctionMain {
    public static void main(String[] args) {
        Function<Integer, Integer> sq = x -> x * x;
        System.out.println(sq.apply(2));
        System.out.println(sq.apply(sq.apply(2)));
        System.out.println(applyTwice(sq, 3));
        System.out.println(applyTwice(a -> a * 2, 3));
        BiFunction<Integer, Double, String> addToStr = (x, y) -> "" + (x + y);
        System.out.println(addToStr.apply(2, 3.5));

        Integer[] arr = { 1, 8, 2, 3, 4 };
        System.out.println(findExtremeValue(arr, (a, b) -> a < b));
        System.out.println(findExtremeValue2(arr, (a, b) -> a < b));
    }

    static int applyTwice(Function<Integer, Integer> f, int x) {
        return f.apply(f.apply(x));

    }

    static <T> T findExtremeValue(T[] arr, BiFunction<T, T, Boolean> compare) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(compare.apply(arr[i], max)){
                max = arr[i];
            }
        }
        return max;
    }

    static <T> T findExtremeValue2(T[] arr, BiPredicate<T, T> compare) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(compare.test(arr[i], max)){
                max = arr[i];
            }
        }
        return max;
    }
}
