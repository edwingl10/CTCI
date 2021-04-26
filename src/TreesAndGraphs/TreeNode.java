package TreesAndGraphs;
import java.io.PrintStream;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val){
        this.val = val;
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
