package fns;

interface Checker<T> {
    boolean check(T x);
}

class IntEvenChecker implements Checker<Integer> {

    @Override
    public boolean check(Integer x) {
        return x % 2 == 0;
    }

}

public class CheckerMain {
    public static void main(String[] args) {
        IntEvenChecker ec = new IntEvenChecker();
        Checker<String> nonEmpty = s -> !s.isEmpty();
        Checker<String> empty = String::isEmpty;
        Checker<String> lengthOne = new Checker<String>() {
            public boolean check(String s) {
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

    static <T> int count(T[] arr, Checker<T> checker) {
        int count = 0;
        for (T x : arr) {
            if (checker.check(x)) {
                count++;
            }
        }
        return count;
    }
}
