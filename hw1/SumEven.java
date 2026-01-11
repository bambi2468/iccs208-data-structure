
public class SumEven {
    public static long sumEven(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumEven(0));
    }
}
