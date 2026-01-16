public class SLList {
    private class IntNode {
        // instance variables
        int head;
        IntNode next;

        public IntNode(int head, IntNode next) {
            this.head = head;
            this.next = next;
        }
    }

    // private IntNode first = null;
    private int actualSize;
    private IntNode sen;

    public SLList() {
        sen = new IntNode(-1, null);
        actualSize = 0;
    }

    public int getFirst() {
        if (sen.next == null) {
            throw new java.util.NoSuchElementException("List is empty");
        }
        return sen.next.head; // this.first.head
    }

    public void addFirst(int x) {
        sen.next = new IntNode(x, sen.next);
        // first = newNode;
        // first = new IntNode(x,first);
        actualSize++;
    }

    public void addLast(int x) {
        IntNode curr = sen;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new IntNode(x, null);
        actualSize++;
    }

    public int size() {
        return actualSize;
    }

    public int getLast() {
        IntNode curr = sen;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr.head;
    }

    public void removeFirst() {
        if (sen.next != null) {
            sen.next = sen.next.next;
            actualSize--;
        }
    }

    public String toString() {
        String str = "";
        IntNode curr = sen.next;
        while (curr != null) {
            str += Integer.toString(curr.head) + " -> ";
            curr = curr.next;
        }
        return str;
    }

    public void insert(int newValue, int k) {
        if (k <= 0) {
            addFirst(newValue);
            return;
        }
        if (k > actualSize) {
            addLast(newValue);
            return;
        }
        IntNode prev = sen;
        int idx = 0;
        while (idx < k) {
            prev = prev.next;
            idx++;
        }
        prev.next = new IntNode(newValue, prev.next);
        actualSize++;
    }
}
