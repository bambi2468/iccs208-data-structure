import java.util.Arrays;
public class Happy {
    public static long sumOfDigitsSquared(long n) {
        long val = n;
        long result = 0;
        while (val > 0) {
            result += Math.pow(val % 10, 2);
            val = val / 10;
        }
        return result;
    }

    public static boolean isHappy(long n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }
        while (n != 1 && n != 4) {
            n = sumOfDigitsSquared(n);
        }
        return n == 1;
    }

    public static long[] firstK(int k) {
        long[] result = new long[k];
        int resultIdx = 0;
        long n = 1;
        while (resultIdx < k){
            if (isHappy(n)){
                result[resultIdx++] = n;
            }
            n++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigitsSquared(145));
        System.out.println(isHappy(989));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Arrays.toString(firstK(11)));
    }
}
