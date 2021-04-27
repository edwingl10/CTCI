package TreesAndGraphs;

public class CheckSubtree {
    /**
     * l and T2 are two very large binary trees, with Tl much bigger than T2.
     * Create an algorithm to determine ifT2 is a subtree of Tl. A tree T2 is a subtree of Tl if
     * there exists a node n in Tl such that the subtree of n is identical to T2. That is, if you cut
     * off the tree at node n, the two trees would be identical.
     */

    boolean containsTree(TreeNode t1, TreeNode t2){
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);

        return string1.indexOf(string2.toString()) != -1;
    }

    void getOrderString(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("X");
            return;
        }
        sb.append(node.val + " ");
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
    }

}
