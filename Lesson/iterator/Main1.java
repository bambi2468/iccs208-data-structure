package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main1 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        for (int x : arr) {
            System.out.println(x);
        }
        System.out.println("-".repeat(20));
        for (int x : new Box()) {
            System.out.println(x);
        }
        Box b = new Box();
        Iterator<Integer> iter = b.iterator();
        while(iter.hasNext()){
            Integer x = iter.next();
            System.out.println(x);
        }
    }
}

class Box implements Iterable<Integer> {
    private int a = 8;
    private int b = 5;
    private int c = 7;

    @Override
    public Iterator<Integer> iterator() {
        return new BoxIterator();
    }

    private class BoxIterator implements Iterator<Integer> {
        int count = 0;

        @Override
        public boolean hasNext() {
            if (count < 3) {
                return true;
            }
            return false;
            // return count < 3
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ;
            count++;
            switch (count) {
                case 1:
                    return a;
                case 2:
                    return b;
                default:
                    return c;
            }
        }
    }
}