package TreesAndGraphs;

public class CheckBalanced {
    /**
     *  Implement a function to check if a binary tree is balanced.
     *  For the purposes of this question, a balanced tree is defined to be a tree such that
     *  the heights of the two subtrees of any node never differ by more than one.
     */
    int checkHeight(TreeNode root){
        if(root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if(rightHeight ==Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight-rightHeight;
        if(Math.abs(heightDiff) > 1)
            return Integer.MIN_VALUE;
        return Math.max(leftHeight, rightHeight)+1;
    }

    // runs in O(N) time and O(H) space, where H is the height of the tree
    boolean isBalanced(TreeNode root){
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static void main(String[] args){
        CheckBalanced cb = new CheckBalanced();

        TreeNode root = new TreeNode(20);
        TreeNode n10 = new TreeNode(10);
        TreeNode n29 = new TreeNode(29);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        TreeNode n25 = new TreeNode(25);
        TreeNode n31 = new TreeNode(31);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);

        root.left = n10;
        root.right = n29;
        n10.left = n5;
        n10.right = n7;
        n29.left = n25;
        n29.right = n31;
        n3.left = n2;
        n2.left = new TreeNode(1);
        System.out.println(cb.isBalanced(root));
    }
}
