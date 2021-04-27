package TreesAndGraphs;

public class Successor {
    /**
     * Write an algorithm to find the "next" node (i.e., in-order successor)
     * of a given node in a binary search tree. You may assume that each node has a link to its parent.
     */

    TreeNode inorderSucc(TreeNode n){
        if(n == null) return null;
        // found right children -> return leftmost node or right subtree
        if(n.right != null){
            return leftMostChild(n.right);
        }else{
            TreeNode q = n;
            TreeNode x = q.parent;

            // go up until we're on left instead of right
            while(x != null && x.left !=q){
                q =x;
                x=x.parent;
            }
            return x;
        }
    }

    TreeNode leftMostChild(TreeNode n){
        if(n == null) return null;
        while(n.left != null){
            n = n.left;
        }
        return n;
    }

    public static void main(String[] args){
        Successor s = new Successor();
        TreeNode root = new TreeNode(20);
        root.insert(root, 30);
        root.insert(root, 10);
        root.insert(root, 5);
        root.insert(root, 15);
        root.insert(root, 3);
        root.insert(root, 7);
        root.insert(root, 17);

        System.out.println(s.inorderSucc(root).val);
    }

}
