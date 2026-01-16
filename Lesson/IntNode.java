public class IntNode {
    // instance variables
    int head;
    IntNode next;

    public IntNode(int head, IntNode next) {
        this.head = head;
        this.next = next;
    }

    public String toString() {
        if (this.next == null) {
            return "" + this.head;
        } else {
            return this.head + ", " + this.next.toString();
        }
    }

    public int size() {
        if (this.next == null)
            return 1;
        else
            return 1 + this.next.size();
    }

    public int iterativeSize() {
        IntNode current = this;
        int totalSize = 0;

        while (current != null) {
            totalSize++;
            current = current.next;
        }
        return totalSize;
    }

    public String iterativeToString() {
        IntNode current = this;
        String str = "";

        while (current != null) {
            if (!str.isEmpty()) {
                str += ", ";
            }
            str += current.head;
            current = current.next;
        }
        return str;
    }

    public int get(int i) {
        IntNode curr = this;
        int idx = 0;

        while (curr != null) {
            if (idx == i) {
                return curr.head;
            }
            curr = curr.next;
            idx++;
        }
        throw new IndexOutOfBoundsException();
    }

    public void set(int i, int newValue) {
        IntNode curr = this;
        int idx = 0;

        while (idx < i) {
            if (curr.next == null) {
                curr.next = new IntNode(0, null);
            }
            curr = curr.next;
            idx++;
        }
        curr.head = newValue;
    }

    public IntNode incrList(int delta) {
        IntNode curr = this;

        while (curr != null) {
            curr.head += delta;
            curr = curr.next;
        }
        return this;
    }

    public static void main(String[] args) {
        IntNode n1 = new IntNode(1, null);
        n1.set(2, 2);
        n1.set(3, 3);

        IntNode n2 = n1.incrList(3);
        System.out.println(n2.iterativeToString());
    }
}
