package fns;

import java.util.function.Predicate;

public class PredicateMain {
    public static void main(String[] args) {
        // IntEvenChecker ec = new IntEvenChecker();
        Predicate<Integer> ec = x -> x % 2 == 0;
        Predicate<String> nonEmpty = s -> !s.isEmpty();
        Predicate<String> empty = String::isEmpty;
        Predicate<String> lengthOne = new Predicate<String>() {
            public boolean test(String s) {
                return s.length() == 1;
            }
        };
        Integer[] arr = { 1, 2, 3, 4, -2 };
        System.out.println(count(arr, ec));
        String[] ss = { "", ".", "edq", " " };
        System.out.println(count(ss, nonEmpty));
        System.out.println(count(ss, empty));
        System.out.println(count(ss, String::isEmpty));
        System.out.println(count(ss, lengthOne));
    }

    static <T> int count(T[] arr, Predicate<T> checker) {
        int count = 0;
        for (T x : arr) {
            if (checker.test(x)) {
                count++;
            }
        }
        return count;
    }
}
