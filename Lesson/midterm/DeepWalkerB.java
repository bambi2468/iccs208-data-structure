import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class DeepWalkerB<T> implements Iterable<T> {
    private final List<List<T>> nestedLists;

    public DeepWalkerB(List<List<T>> nestedLists) {
        if (nestedLists == null) {
            nestedLists = Collections.emptyList();
        }
        this.nestedLists = nestedLists;
    }

    @Override
    public Iterator<T> iterator() {
        return new DeepWalkerBIterator();
    }

    private class DeepWalkerBIterator implements Iterator<T> {
        private final Iterator<List<T>> rowIter = nestedLists.iterator();
        private Iterator<T> colIter = Collections.emptyIterator();

        @Override
        public boolean hasNext() {
            while (!colIter.hasNext() && rowIter.hasNext()) {
                List<T> row = rowIter.next();
                if (row != null) {
                    colIter = row.iterator();
                }
            }
            return colIter.hasNext();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            return colIter.next();
        }
    }
}
