package LinkedLists;

public class SumLists {
    /**
     * You have two numbers represented by a linked list, where each node contains a single digit.
     * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
     * Write a funtion that adds the two numbers and returns the sum as a linked list
     * EXAMPLE
     * Input: (7->1->6) + (5->9->2) that is 617 + 295
     * Output: 2->1->9. That is 912
     */

    static Node sum(Node n1, Node n2){
        if(n1 == null) return n2;
        if(n2 == null) return n1;

        int sum = n1.data + n2.data;
        int carry = sum / 10;
        Node tmp1 = n1.next;
        Node tmp2 = n2.next;
        Node result = new Node(sum%10);

        while(tmp1 != null && tmp2 != null){
            sum = tmp1.data + tmp2.data;
            result.addToEnd((sum+carry) % 10);
            carry = sum /10;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        if(tmp2 == null){
            while(tmp1 != null){
                sum = tmp1.data + carry;
                carry = sum/10;
                result.addToEnd(sum % 10);
                tmp1 = tmp1.next;
            }
        }
        if(tmp1 == null){
            while(tmp2 != null){
                sum = tmp2.data + carry;
                carry = sum /10;
                result.addToEnd(sum % 10);
                tmp2 = tmp2.next;
            }
        }

        return result;
    }

    public static void main(String[] args){
        Node node1 = new Node(7);
        node1.addToEnd(1);
        node1.addToEnd(6);

        Node node2 = new Node(5);
        node2.addToEnd(9);
        node2.addToEnd(2);

        Node result1 = sum(node1, node2);
        result1.printList();
    }
}
