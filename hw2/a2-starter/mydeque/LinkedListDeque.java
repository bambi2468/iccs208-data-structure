public class LinkedListDeque<T> {
    private class Node {
        T head;
        Node prev;
        Node next;

        public Node(T head, Node prev, Node next) {
            this.head = head;
            this.next = next;
            this.prev = prev;
        }
    }

    private int actualSize;
    private Node sen;

    public LinkedListDeque() {
        sen = new Node(null, null, null);
        sen.prev = sen;
        sen.next = sen;
        actualSize = 0;
    }

    public LinkedListDeque(LinkedListDeque<T> other) {
        this(); // start with an empty deque

        Node curr = other.sen.next;
        for (int i = 0; i < other.actualSize; i++) {
            this.addLast(curr.head);
            curr = curr.next;
        }
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        Node newNode = new Node(item, sen, sen.next);
        sen.next.prev = newNode;
        sen.next = newNode;
        actualSize++;
    }

    // Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        Node newNode = new Node(item, sen.prev, sen);
        sen.prev.next = newNode;
        sen.prev = newNode;
        actualSize++;
    }

    public boolean isEmpty() {
        return actualSize == 0;
    }

    // Returns the number of items in the deque.
    public int size() {
        return actualSize;
    }

    // Returns a string showing the items in the deque from first to last,
    // separated by a space.
    public String toString() {
        String result = "";
        if (actualSize > 0) {
            Node curr = sen.next;
            for (int i = 0; i < actualSize; i++) {
                result += curr.head;
                if (i < actualSize - 1) {
                    result += " ";
                }
                curr = curr.next;
            }
        }
        return result;
    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if (actualSize == 0) {
            return null;
        }

        Node first = sen.next;
        T removedItem = first.head;

        sen.next = first.next;
        first.next.prev = sen;

        actualSize--;
        return removedItem;
    }

    public T removeLast() {
        if (actualSize == 0) {
            return null;
        }

        Node last = sen.prev;
        T removedItem = last.head;

        sen.prev = last.prev;
        last.prev.next = sen;

        actualSize--;
        return removedItem;
    }

    public T get(int index) {
        if (index < 0 || index >= actualSize) {
            return null;
        }

        Node curr = sen.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.head;
    }
}
