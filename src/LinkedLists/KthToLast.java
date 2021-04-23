package LinkedLists;

class Index {
    int value = 0;
}
public class KthToLast {
    // if linked list size is known
    static int returnKthToLast(Node head, int kth){
        if(kth < 1) return -1;
        int count=0;
        Node result = head;
        while(count < head.length-kth){
            result = result.next;
            count++;
        }
        return result.data;
    }


    // recursive
    static Node KthToLast(Node head, int k){
        Index idx = new Index();
        return kthToLast(head, k, idx);
    }
    static Node kthToLast(Node head, int k, Index idx){
        if(head == null) return null;
        Node node = kthToLast(head.next, k, idx);
        idx.value++;
        if(idx.value == k){
            return head;
        }
        return node;
    }

    public static void main(String[] args){
        Node node = new Node(2);
        node.addToEnd(3);
        node.addToEnd(5);
        node.addToEnd(9);
        node.addToEnd(7);

        System.out.println(returnKthToLast(node, 3));
        Node result = KthToLast(node, 3);
        System.out.println(result.data);
    }
}
