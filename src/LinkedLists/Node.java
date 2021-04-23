package LinkedLists;

public class Node {
    int data;
    Node next = null;
    int length;

    Node(int val){
        this.data =  val;
        this.length =1;
    }

    void addToEnd(int val){
        Node head = this;
        while(head.next != null){
            head = head.next;
        }
        head.next = new Node(val);
        this.length++;
    }

    void printList(){
        Node n = this;
        while(n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }
}