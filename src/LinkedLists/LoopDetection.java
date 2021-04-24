package LinkedLists;

public class LoopDetection {
    /**
     * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
     * DEFINITION Circular linked list: A (corrupt) linked list in which a node's next pointer points to
     * an earlier node, so as to make a loop in the linked list.
     * EXAMPLE:
     * Input: a->b->c->d->e->c [same c as earlier]
     * output: c
     */

    /*
    1. create 2 pointers, fast and slow
    2. move fast pointer at a rate of 2 steps and slow pointer at a rate of 1 step
    3. when they collide, move slow pointer to head. Keep fast pointer where it is
    4. Move slow and fast pointer at a rate of one set. Return the new collision point
     */
    static Node loopNode(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        slow = head;
        while(slow != fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
    public static void main(String[] args){
        Node node = new Node(1);
        node.addToEnd(2);
        node.addToEnd(3);
        node.addToEnd(4);
        node.addToEnd(5);

        Node tmp = node.next.next;
        node.next.next.next.next = tmp;

        System.out.println(loopNode(node).data);
    }
}
