import java.math.BigInteger;
import java.util.Arrays;

public class Exercise2 {
    public static int numTrailingZeros(int n) {
        BigInteger nFac = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            nFac = nFac.multiply(BigInteger.valueOf(i));
        }
        int lastDigit = nFac.toString().length() - 1;
        int countZero = 0;
        while (nFac.toString().charAt(lastDigit) == '0') {
            countZero += 1;
            lastDigit--;
        }
        return countZero;
    }

    public static void windowPosSum(int[] a, int n) {
        int[] result = Arrays.copyOf(a, a.length);

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                int sum = 0;
                for (int j = i; j <= i + n && j < a.length; j++) {
                    sum += a[j];
                }
                result[i] = sum;
            }
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, -3, 4, 5, 4 };
        int n = 3;
        // System.out.println(numTrailingZeros(20));
        windowPosSum(a, n);
    }
}
