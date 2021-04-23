package LinkedLists;

public class Partition {
    /**
     * Write code to partition a linked list around a value x, such that all nodes less than x
     * come before all nodes greater than or equal to x. If x is contained within the list, the values of x only
     * need to be after the elemeents less than x. The partition element x can appear anywhere in teh "right position"
     * it does not need to appear between the left and right partitions.
     * EXAMPLE
     * Input: 3->5->8->5->10->2->1 [partition=5]
     * Output: 3->1->2->10->5->5->8
     */

    static Node part(Node head, int part){
        Node less=null;
        Node lastLess = less;
        Node more=null;

        Node tmp = head;
        while(tmp != null){
            if(tmp.data < part){
                if(less != null){
                    less.addToEnd(tmp.data);
                }else{
                    less = new Node(tmp.data);
                }
                lastLess = less.next;

            }else{
                if(more != null){
                    more.addToEnd(tmp.data);
                }else{
                    more = new Node(tmp.data);
                }
            }
            tmp = tmp.next;
        }


        lastLess.next.next = more;
        return less;
    }
    public static void main(String[] args){
        Node node = new Node(3);
        node.addToEnd(5);
        node.addToEnd((8));
        node.addToEnd(5);
        node.addToEnd(10);
        node.addToEnd(2);
        node.addToEnd(1);

        part(node, 5).printList();
    }
}
