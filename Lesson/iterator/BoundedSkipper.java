package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BoundedSkipper implements Iterable<Integer> {
    private int k;
    private int n;

    public BoundedSkipper(int k, int n) {
        this.k = k;
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int count = 0;
            int candidate = 1;

            @Override
            public boolean hasNext() {
                return count < n;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                count++;
                while (true) {
                    String candidateTxt = "" + candidate;
                    String kTxt = "" + k;
                    if (candidate % k == 0 || candidateTxt.contains(kTxt)) {
                        candidate++;
                    } else {
                        int temp = candidate;
                        candidate++;
                        return temp;
                    }
                }

            }

        };
    }

    public static void main(String[] args) {
        for (int v : new BoundedSkipper(3, 11)) {
            System.out.println(v); // prints out the above sequence on separate lines
        }
    }
}
