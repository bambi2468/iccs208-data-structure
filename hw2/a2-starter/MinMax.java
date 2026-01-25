public class MinMax {
    public static double minMaxAverage(int[] numbers) {
        int n = numbers.length;
        int myMin, myMax;
        int i;

        // If n is even, num[0]<num[1] = num[0]==min & num[1]==max
        if (n % 2 == 0) {
            if (numbers[0] < numbers[1]) {
                myMin = numbers[0];
                myMax = numbers[1];
            } else {
                myMin = numbers[1];
                myMax = numbers[0];
            }
            i = 2;
        }
        // If n is odd, set both min&max = num[0] so that we can pair checking later on.
        else {
            myMin = numbers[0];
            myMax = numbers[0];
            i = 1;
        }

        // loop for the rest in int[] num
        while (i < n - 1) {
            int localMin, localMax;

            // 1 comparison between the pair
            if (numbers[i] < numbers[i + 1]) {
                localMin = numbers[i]; // set local var so that we dont if check everytime
                localMax = numbers[i + 1];
            } else {
                localMin = numbers[i + 1];
                localMax = numbers[i];
            }

            // check
            if (localMin < myMin)
                myMin = localMin;
            if (localMax > myMax)
                myMax = localMax;

            i += 2; // skip 2, since we already check both in pair.
        }

        return (myMin + myMax) / 2.0;
    }
}
