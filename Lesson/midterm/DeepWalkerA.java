import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class DeepWalkerA<T> implements Iterable<T> {
    private final List<List<T>> nestedLists;

    public DeepWalkerA(List<List<T>> nestedLists) {
        if (nestedLists == null) {
            nestedLists = Collections.emptyList();
        }
        this.nestedLists = nestedLists;
    }

    @Override
    public Iterator<T> iterator() {
        return new DeepWalkerAIterator();
    }

    private class DeepWalkerAIterator implements Iterator<T> {
        private int rowIdx = 0;
        private int colIdx = 0;

        @Override
        public boolean hasNext() {
            while (rowIdx < nestedLists.size()) {
                List<T> row = nestedLists.get(rowIdx);
                if (row != null && colIdx < row.size()) {
                    return true;
                }
                rowIdx++;
                colIdx = 0;
            }
            return false;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            T element = nestedLists.get(rowIdx).get(colIdx);
            colIdx++;
            return element;
        }
    }
}