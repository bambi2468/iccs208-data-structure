import java.util.Arrays;

public class Subsel {
    public static int[] takeEvery(int[] a, int stride, int beginWith) {
        if (stride == 0) {
            throw new IllegalArgumentException("stride must be greater or less than 0");
        }
        int count = 0;
        for (int i = 0; beginWith + (stride * i) < a.length && beginWith + (stride * i) >= 0; i++) {
            count++;
        }
        int[] ans = new int[count];
        for (int i = 0; i < count; i++) {
            ans[i] = a[beginWith + (stride * i)];
        }
        return ans;
    }

    public static int[] takeEvery(int[] a, int stride) {
        return takeEvery(a, stride, 0);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(takeEvery(new int[] { 1, 2, 3, 4 }, 2)));
        System.out.println(Arrays.toString(takeEvery(new int[] { 2, 7, 1, 8, 4, 5 }, 3, 2)));
        System.out.println(Arrays.toString(takeEvery(new int[] { 3, 1, 4, 5, 9, 2, 6, 5 }, -1, 5)));
    }
}
