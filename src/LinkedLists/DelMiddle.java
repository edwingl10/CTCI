package LinkedLists;

public class DelMiddle {
    /**
     * Implement an algorithm to delete a node in the middle (any node but the first and last node,
     * not necessarily the exact middle) of a singly linked list, given only access to that node.
     * e.g. Input: the node c from the linked list a->b->c->d->e->f
     * result: nothing returned but the new linked list looks like a->b->d->e->f
     */

    static void deleteMiddle(Node node){
        if(node == null || node.next == null) return;
        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
    }

    public static void main(String[] args){
        Node node = new Node(3);
        node.addToEnd(1);
        node.addToEnd(12);
        node.addToEnd(14);
        node.addToEnd(10);

        Node toDelete = node.next.next;
        deleteMiddle(toDelete);
        node.printList();
    }
}
