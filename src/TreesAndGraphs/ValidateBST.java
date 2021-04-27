package TreesAndGraphs;

public class ValidateBST {
    /**
     * Implement a function to check if a binary tree is a binary search tree.
     */
    boolean isBST(TreeNode root){
        return checkBst(root, null, null);
    }
    boolean checkBst(TreeNode root, Integer min, Integer max){
        if(root == null ) return true;

        if((min != null && root.val <= min) || (max != null && root.val > max))
            return false;

        // if any side returns false
        if(!checkBst(root.left, min, root.val) || !checkBst(root.right, root.val, max))
            return false;

        return true;
    }

    public static void main(String[] args){
        ValidateBST vb = new ValidateBST();

        TreeNode root = new TreeNode(20);
        TreeNode n10 = new TreeNode(10);
        TreeNode n30 = new TreeNode(30);
        TreeNode n5 = new TreeNode(5);
        TreeNode n15 = new TreeNode(15);
        TreeNode n3 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7);
        TreeNode n17 = new TreeNode(17);

        root.left = n10;
        root.right = n30;
        n10.left = n5;
        n10.right = n15;
        n15.right = n17;
        n5.left = n3;
        n5.right = n7;

        root.print2D(root);


        System.out.print(vb.isBST(root));
    }
}
