public class L2 {
    public static int maxFor(int[] numbers) {
        int maxSoFar = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxSoFar) {
                maxSoFar = numbers[i];
            }
        }
        return maxSoFar;
    }
    public static void main(String[] args) {
        System.err.println("!Error");
    }
}