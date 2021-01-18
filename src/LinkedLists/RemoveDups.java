package LinkedLists;
import java.util.Hashtable;

class Node {
    int data;
    Node next = null;

    Node(int val){
        this.data =  val;
    }

    void addToEnd(int val){
        Node head = this;
        while(head.next != null){
            head = head.next;
        }
        head.next = new Node(val);
    }

    void printList(){
        Node n = this;
        while(n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }
}

public class RemoveDups {
    /*
     * write code to remove duplicates from an unsorted linked list.
     * How would you solve this problem if a temporary buffer is not allowed?
     */

    // uses hash table
    static void RemoveDuplicates(Node head){
        Hashtable<Integer,Integer> map = new Hashtable();
        Node tmp = head;
        Node prev = null;

        while(tmp != null){
            if(map.containsKey(tmp.data)){
                prev.next = tmp.next;
            }
            else{
                map.put(tmp.data, 1);
                prev = tmp;
            }
            tmp = tmp.next;
        }
    }


    public static void main(String[] args){
        RemoveDups rd = new RemoveDups();

        Node head = new Node(2);
        head.addToEnd(3);
        head.addToEnd(1);
        head.addToEnd(2);
        head.addToEnd(3);
        head.addToEnd(4);

        head.printList();
        System.out.println("After duplicates are removed");
        rd.RemoveDuplicates(head);
        head.printList();
    }
}
