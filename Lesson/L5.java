class AList {
    private int[] items; // storage for data items
    private int size; // number of actual items in the list

    public AList() {
        size = 0;
        items = new int[10];
    }

    public void resize(int newCapacity) {
        int[] newItems = new int[newCapacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
        
    }

    public int getFirst() {
        return items[0];
    }

    public int getLast() {
        return items[size - 1];
    }

    public void addLast(int x) {
        if (size == items.length) {
            resize(items.length*2);
        }
        items[size++] = x;
    }

    public void removeLast() {
        size--;
        items[size] = 0;
    }

}

public class L5 {
    public static void main(String[] args) {
        AList list = new AList();
        for (int i = 1; i <= 500_000; i++) {
            list.addLast(i);
            
        }
        System.err.println(list.getLast());
    }
}


//1+3+5+...

//