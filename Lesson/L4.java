public class L4 {
    public static void main(String[] args) {
        SLList L = new SLList();

        L.addLast(2);
        L.addLast(1);
        L.addFirst(5);
        // System.out.println(L.getLast());
        // System.out.println(L.getFirst());
        System.out.println(L.toString());
        L.removeFirst();

        // System.out.println(L.getFirst());
        System.out.println(L.toString());
        L.insert(0, 0);
        
        System.out.println(L.toString());
        L.insert(6, 2);
        System.out.println(L.toString());
        L.insert(8, 3);
        System.out.println(L.toString());
        L.insert(7, 2);
        System.out.println(L.toString());
    }
}
