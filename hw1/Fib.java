import java.math.BigInteger;

public class Fib {
    public static int firstNDigit(int n) {
        if (n == 1) return 1;
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int i = 2;
        while (true) {
            BigInteger c = a.add(b);
            // System.out.println(c);
            i++;
            int numDigit = c.toString().length();
            if (numDigit == n) {
                return i;
            }
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        // int n = 3;
        // BigInteger a = BigInteger.ONE;
        // BigInteger b = BigInteger.ONE;
        // for (int i = 3; i < 1000; i++) {
        //     BigInteger c = a.add(b);
        //     System.out.println(c);
        //     int numDigit = c.toString().length();
        //     if (numDigit == n) {
        //         System.out.println("i= " + i);
        //         break;

        //     }
        //     a = b;
        //     b = c;
        // }
        System.out.println(firstNDigit(3));
    }
}
