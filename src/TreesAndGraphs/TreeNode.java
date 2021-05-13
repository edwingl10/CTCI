package TreesAndGraphs;
import java.io.PrintStream;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    TreeNode(int val){
        this.val = val;
    }

    TreeNode insert(TreeNode node, int data)
    {

        /* 1. If the tree is empty, return a new,
         single node */
        if (node == null) {
            return new TreeNode(data);
        }
        else {

            TreeNode temp = null;

            /* 2. Otherwise, recur down the tree */
            if (data <= node.val) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            }
            else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }

            /* return the (unchanged) node pointer */
            return node;
        }
    }

    // ************ for debugging purposes ************** //
    void print2DUtil(TreeNode root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += 10;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.val + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    void print2D(TreeNode root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }
}
