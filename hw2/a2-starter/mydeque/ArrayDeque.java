public class ArrayDeque<T> {
    private T[] items;
    private int actualSize;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        actualSize = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque(ArrayDeque<T> other) {
        this();
        for (int i = 0; i < other.actualSize; i++) {
            this.addLast(other.get(i));
        }
    }

    public void addFirst(T item) {
        if (actualSize == items.length) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        actualSize++;
    }

    public void addLast(T item) {
        if (actualSize == items.length) {
            resize(items.length * 2);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        actualSize++;
    }

    public boolean isEmpty() {
        return actualSize == 0;
    }

    public int size() {
        return actualSize;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < actualSize; i++) {
            result += get(i);
            if (i < actualSize - 1) {
                result += " ";
            }
        }
        return result;
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    public T removeFirst() {
        if (actualSize == 0) {
            return null;
        }

        int firstIndex = plusOne(nextFirst);
        T removedItem = items[firstIndex];

        items[firstIndex] = null; // avoid dangling references
        nextFirst = firstIndex;
        actualSize--;

        checkShrink();
        return removedItem;
    }

    public T removeLast() {
        if (actualSize == 0) {
            return null;
        }

        int lastIndex = minusOne(nextLast);
        T removedItem = items[lastIndex];

        items[lastIndex] = null; // avoid dangling references
        nextLast = lastIndex;
        actualSize--;

        checkShrink();
        return removedItem;
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int curr = plusOne(nextFirst);

        for (int i = 0; i < actualSize; i++) {
            newItems[i] = items[curr];
            curr = plusOne(curr);
        }

        items = newItems;
        nextFirst = capacity - 1;
        nextLast = actualSize;
    }

    private void checkShrink() {
        if (items.length >= 16 && actualSize < items.length / 4) {
            resize(items.length / 2);
        }
    }

    public T get(int index) {
        if (index < 0 || index >= actualSize)
            return null;
        int start = plusOne(nextFirst);
        return items[(start + index) % items.length];
    }
}
