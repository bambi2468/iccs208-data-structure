// public class SLList {
//     private class IntNode {
//         // instance variables
//         int head;
//         IntNode next;

//         public IntNode(int head, IntNode next) {
//             this.head = head;
//             this.next = next;
//         }
//     }

//     // private IntNode first = null;
//     private int actualSize;
//     private IntNode sen;

//     public SLList() {
//         sen = new IntNode(-1, null);
//         actualSize = 0;
//     }

//     public int getFirst() {
//         if (sen.next == null) {
//             throw new java.util.NoSuchElementException("List is empty");
//         }
//         return sen.next.head; // this.first.head
//     }

//     public void addFirst(int x) {
//         sen.next = new IntNode(x, sen.next);
//         actualSize++;
//     }

//     public void addLast(int x) {
//         IntNode curr = sen;
//         while (curr.next != null) {
//             curr = curr.next;
//         }
//         curr.next = new IntNode(x, null);
//         actualSize++;
//     }

//     public int size() {
//         return actualSize;
//     }

//     public int getLast() {
//         IntNode curr = sen;
//         while (curr.next != null) {
//             curr = curr.next;
//         }
//         return curr.head;
//     }

//     public void removeFirst() {
//         if (sen.next != null) {
//             sen.next = sen.next.next;
//             actualSize--;
//         }
//     }

//     public String toString() {
//         String str = "";
//         IntNode curr = sen.next;
//         while (curr != null) {
//             str += Integer.toString(curr.head) + " -> ";
//             curr = curr.next;
//         }
//         return str;
//     }

//     public void insert(int newValue, int k) {
//         if (k <= 0) {
//             addFirst(newValue);
//             return;
//         }
//         if (k > actualSize) {
//             addLast(newValue);
//             return;
//         }
//         IntNode prev = sen;
//         int idx = 0;
//         while (idx < k) {
//             prev = prev.next;
//             idx++;
//         }
//         prev.next = new IntNode(newValue, prev.next);
//         actualSize++;
//     }
// }


import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLList implements Iterable<Integer> {
    private class IntNode {
        int value;
        IntNode next;
        public IntNode(int val, IntNode r) {
            this.value = val; this.next = r;
        }
    }

    private IntNode first;
    private int size; 

    public SLList() { 
        first = null; 
        size = 0;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
        size++;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SLListIterator();
    }

    private class SLListIterator implements Iterator<Integer> {
        private IntNode curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int val = curr.value;
            curr = curr.next;
            return val;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof SLList)) return false;

        SLList other = (SLList) o;

        if (this.size != other.size) return false;

        IntNode p1 = this.first;
        IntNode p2 = other.first;
        while (p1 != null) {
            if (p1.value != p2.value) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public double getAverage() {
        double total = 0;
        IntNode curr = sen.next;
        while (curr != null) {
            total += curr.head;
            curr = curr.next;
        }
        return total / size();
    }

    public int find(int x) {
        IntNode curr = sen.next;
        int idx = 0;
        while (curr != null) {
            if (curr.head == x) {
                return idx;
            }
            idx++;
            curr = curr.next;
        }
        return -1;
    }

    public boolean contain(int x) {
        IntNode curr = sen.next;
        while (curr != null) {
            if (curr.head == x) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

}
