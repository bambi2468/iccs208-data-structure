package iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class NestedList<T> implements Iterable<T> {
    List<List<T>> matrix;

    public NestedList(List<List<T>> matrix) {
        this.matrix = matrix;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = 0;
            int j = 0;

            private boolean shouldMoveToNextRow() {
                if (i >= matrix.size()) {
                    return false;
                }
                List<T> row = matrix.get(i);
                // pointed to null
                if (row == null) {
                    return true;
                }
                // exceed the row
                if (j >= row.size()) {
                    return true;
                }
                return false;
            }

            public boolean hasNext() {
                int ti = i;
                int tj = j;
                // loop always run except i is exceed the amount of row
                while (ti < matrix.size()) {
                    List<T> row = matrix.get(ti);

                    // if the row is null -> moving to the next row
                    if (row == null) {
                        ti++;
                        tj = 0;
                        continue;
                    }

                    // if j exceed the amount in the row -> go to next row
                    if (tj >= row.size()) {
                        ti++;
                        tj = 0;
                        continue;
                    }

                    // if the element inside is null -> mov to next element in the row
                    // if (row.get(tj) == null) {
                    if (tj < row.size() && row.get(tj) == null) {
                        tj++;
                        continue;
                    }
                    return true;
                }
                // not finding anything until it reach the end of the matrix
                return false;
            }

            public T next() {
                // the last element
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                // in case moving to a next row
                while (shouldMoveToNextRow()) {
                    i++;
                    j = 0;
                }
                List<T> row = matrix.get(i);
                // if the element is null -> moving to the next element in the row
                while (j < row.size() && row.get(j) == null) {
                    j++;
                    // in case moving until it exceeding the end of the row -> moving to the new
                    // row. == loop is still running
                    while (shouldMoveToNextRow()) {
                        i++;
                        j = 0;
                        row = matrix.get(i);
                    }
                }
                // in case we move until we are at the end of the matrix
                // if (j >= row.size()){
                // throw new NoSuchElementException();
                // }

                // should be able to find the non-null element
                T val = row.get(j);
                j++;
                return val;
            }

        };
    }

    public static void main(String[] args) {
        // List<Integer> ii = List.of(1,2,3);
        // List<List<Integer>> m = List.of(
        // List.of(2, 3),
        // null,
        // List.of(2, null),
        // List.of(null, 3),
        // List.of(null, 6, null),
        // List.of(null, null, null),
        // List.of(4, null, 7),
        // List.of(4, 6, 7));

        List<List<Integer>> m = Arrays.asList(
                Arrays.asList(2, 3),
                null,
                Arrays.asList(2, null),
                Arrays.asList(null, 3),
                Arrays.asList(null, 6, null),
                Arrays.asList(null, null, null),
                Arrays.asList(4, null, 7),
                Arrays.asList(4, 6, 7));
        NestedList<Integer> nl = new NestedList<>(m);
        for (int x : nl) {
            System.out.println(x);
        }

    }

}
