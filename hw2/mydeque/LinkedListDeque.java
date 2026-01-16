package hw2.mydeque;

public class LinkedListDeque<T> {
    private class Node {
        // instance variables
        T head;
        Node prev;
        Node next;

        public Node(T head, Node prev, Node next) {
            this.head = head;
            this.prev = prev;
            this.next = next;
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

    // Returns true if deque is empty, false otherwise.
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
        String str = "";
        Node curr = sen.next;
        while (curr != sen) {
            if (!str.isEmpty()) {
                str += " ";
            }
            str += curr.head;
            curr = curr.next;
        }
        return str;
    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if (!isEmpty()) {
            T item = sen.next.head;
            sen.next = sen.next.next;
            sen.next.prev = sen;
            actualSize--;
            return item;
        }
        return null;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {
        if (!isEmpty()) {
            T item = sen.prev.head;
            sen.prev = sen.prev.prev;
            sen.prev.next = sen;
            actualSize--;
            return item;
        }
        return null;
    }

    // Gets the item at the given index, where 0 is the front, 1 is the next item,
    // and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if (index < 0 || index >= actualSize){
            return null;
        }
        Node curr = sen.next;
        for (int i = 0; i < index;i++){
            curr = curr.next;
        }
        return curr.head;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> list = new LinkedListDeque<>();
        list.addLast(2);
        list.addFirst(8);
        list.addLast(5);
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.get(8));
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);


        LinkedListDeque<Integer> list2 = new LinkedListDeque<>();
        list2.addFirst(1);
        list2.removeFirst();
        System.out.println(list2);
        list2.addLast(9);
        System.out.println(list2);
        list2.removeLast();
        System.out.println(list2);
    }
}
