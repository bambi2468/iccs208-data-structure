package fns;

interface IntChecker {
    boolean check(int x);
}

class EvenChecker implements IntChecker {

    @Override
    public boolean check(int x) {
        return x % 2 == 0;
    }
}

public class IntCheckerMain {
    public static void main(String[] args) {
        EvenChecker ec = new EvenChecker();
        IntChecker pc = a -> a >= 0;
        System.out.println(ec.check(4));
        int[] arr = { 1, 2, 3, 4, -2 };
        System.out.println(countInts(arr, ec));
        System.out.println(countInts(arr, pc));
    }

    static int countInts(int[] arr, IntChecker checker) {
        int count = 0;
        for (int x : arr) {
            if (checker.check(x)) {
                count++;
            }
        }
        return count;
    }
}
