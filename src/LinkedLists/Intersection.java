package LinkedLists;

public class Intersection {
    /**
     * Given two (singly) linked lists, determine if  the two lists intersect.
     * Return the intersecting node. Note that the intersection is defined based on reference, not value.
     * That is, if the kth node of the first linked list is the exact same node (by reference)
     * as the jth node of the second linked list, then they are intersecting.
     */
    static Node findIntersection(Node n1, Node n2){
        if(n1 == null || n2 == null) return null;

        Node shorter = n1.length < n2.length ? n1: n2;
        Node longer = n1.length < n2.length ? n2: n1;
        longer = getKth(longer, Math.abs(n1.length - n2.length));

        while(shorter != longer){
            shorter = shorter.next;
            longer= longer.next;
        }
        return longer;
    }

    static Node getKth(Node head, int k){
        Node current = head;
        while(k > 0 && current != null){
            current = current.next;
            k--;
        }
        return current;
    }


    public static void main(String[] args){
        Node head1 = new Node(3);
        head1.addToEnd(1);
        head1.addToEnd(5);
        head1.addToEnd(9);
        head1.addToEnd(7);
        head1.addToEnd(2);
        head1.addToEnd(1);

        Node ref = head1.next.next.next.next;

        Node head2 = new Node(4);
        head2.addToEnd(6);
        head2.next.next=ref;
        head2.length = 5;

        Node intersecting = findIntersection(head1, head2);
        System.out.println(intersecting.data);
    }
}
