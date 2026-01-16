
// import java.lang.reflect.Array;
import java.util.Arrays;

public class Unknown {
    public static int w;
    private static int x;
    private int y;
    public int[] z = new int[5];

    public Unknown() {
        w += 1;
        y = w;
    }

    public static void setX(int i) {
        x += i;
    }

    public void setZ(int i) {
        z[y] = i;
        y += 1;
    }

    public int getW() {
        return w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ(int i) {
        return z[i];
    }

}
