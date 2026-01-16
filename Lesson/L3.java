// package Lesson;
class Node {
    Usr usrInfo;
    Node next;

    public Node(Usr usrInfo, Node next) {
        this.usrInfo = usrInfo;
        this.next = next;

    }
}

class Usr {
    int id;
    String usrName;

    public Usr(int id, String usrName) {
        this.id = id;
        this.usrName = usrName;
    }
}

public class L3 {

    public static Node appendNode(Node head, Usr nextNode) {
        if (head == null){
            return new Node(nextNode, null);
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(nextNode, null);
        return head;
    }

    public static int iterativeSize(Node head) {
        Node current = head;
        int count = 1;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public static void iterativeToString(Node head) {
        Node current = head;
        String strId = "";
        String strNames = "";
        while (current != null) {
            if (!strId.isEmpty()) {
                strId += ", ";
            }
            if (!strNames.isEmpty()) {
                strNames += ", ";
            }
            strId += current.usrInfo.id ;
            strNames += current.usrInfo.usrName ;
            current = current.next;
        }
        System.out.println("ids: "+strId+"\n"+"accounts: "+ strNames);
    }

    // public int size() {
    // if (this.next == null)
    // return 1;
    // else
    // return 1 + this.next.size();
    // }

    public static void main(String[] args) {
        Usr usr1 = new Usr(6780909, "Bambi");
        Usr usr2 = new Usr(6788979, "ayo");
        Node list = null;
        list = appendNode(appendNode(list, usr1),usr2);
        // Node n1 = new Node(usr1, null);
        // n1 = appendNode(n1, usr2);
        // System.out.println(iterativeSize(n1));
        iterativeToString(list);
    }
}
