public class Diamond {
    public static void printDiamond(int k) {
        int totalChar = 2 * k + 1;
        for (int i = 0; i < k; i++) {
            int numSharp = k - i;
            int numStar = totalChar - numSharp * 2;
            String sharp = "#".repeat(numSharp);
            String star = "*".repeat(numStar);
            System.out.println(sharp + star + sharp);
        }
        for (int i = 0; i < k - 1; i++) {
            int numSharp = 2 + i;
            int numStar = totalChar - numSharp * 2;
            String sharp = "#".repeat(numSharp);
            String star = "*".repeat(numStar);
            System.out.println(sharp + star + sharp);
        }
    }

    public static void main(String[] args) {
        printDiamond(3);
    }

}
