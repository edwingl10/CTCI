package LinkedLists;
import java.util.Stack;

public class Palindrome {
    /**
     * Implement a function to check if a linked list is a palindrome.
     */

    // uses stack
    public static boolean isPalindrome(Node head){
        Stack<Integer> st = new Stack<Integer>();
        int middle = head.length /2;
        int index = 0;
        Node tmp = head;

        while(index < middle){
            st.push(tmp.data);
            tmp = tmp.next;
            index++;
        }
        if(head.length % 2 != 0){
            tmp=tmp.next;
        }

        while(st.size() != 0){
            int top = st.pop();
            if(top != tmp.data) return false;
            tmp = tmp.next;
        }
        return true;
    }

    public static void main(String[] args){
        Node head = new Node(0);
        head.addToEnd(1);
        head.addToEnd(2);
        head.addToEnd(2);
        head.addToEnd(1);
        head.addToEnd(0);

        System.out.println(isPalindrome(head));
    }
}
