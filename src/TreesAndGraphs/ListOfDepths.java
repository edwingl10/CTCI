package TreesAndGraphs;
import java.util.LinkedList;
import java.util.ArrayList;

public class ListOfDepths {
    /**
     * Given a binary tree, design an algorithm which creates a linked list
     * of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
     */

    // mod of pre-order traversal algo
    // we pass level+1 to next recursive call
    void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
        if(root == null) return;

        LinkedList<TreeNode> list = null;
        if(lists.size() == level){ //level not contained in list
            list = new LinkedList<TreeNode>();
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level+1);
        createLevelLinkedList(root.right, lists, level+1);
    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    // mod of breadth-first search. we iterate through the root first, then level 2, then level 3 and so on
    ArrayList<LinkedList<TreeNode>> createLevelList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if(root != null){
            current.add(root);
        }

        while (current.size() > 0){
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();

            for(TreeNode parent: parents){
                if(parent.left != null)
                    current.add(parent.left);
                if(parent.right != null)
                    current.add(parent.right);
            }
        }

        return  result;
    }

    public void printLevels(ArrayList<LinkedList<TreeNode>> lists){
        for(int i=0; i<lists.size(); i++){
            System.out.println("Level: " + i);
            for(int j=0; j<lists.get(i).size(); j++){
                System.out.print(lists.get(i).get(j).val + ", ");
            }
            System.out.println("\n");
        }
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode n8 = new TreeNode(8);
        TreeNode n15 = new TreeNode(15);
        TreeNode n5 = new TreeNode(5);
        TreeNode n9 = new TreeNode(9);
        TreeNode n14 = new TreeNode(14);
        TreeNode n20 = new TreeNode(20);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);

        root.left = n8;
        root.right = n15;
        n8.left = n5;
        n8.right =n9;
        n5.left = n4;
        n5.right = n6;
        n15.left = n14;
        n15.right = n20;

        ListOfDepths ld = new ListOfDepths();
        ArrayList<LinkedList<TreeNode>> result = ld.createLevelLinkedList(root);
        ld.printLevels(result);

        System.out.println("========= OTHER METHOD =============");
        ArrayList<LinkedList<TreeNode>> result2 = ld.createLevelList(root);
        ld.printLevels(result2);
    }
}
