package TreesAndGraphs;

public class MinimalTree {
    /**
     * Given a sorted (increasing order) array with unique integer elements,
     * write an algorithm to create a binary search tree with minimal height.
     */

    /*
    1. insert into the tree the middle element of the array
    2. insert into the left subtree the left subarray elements
    3. insert into the right subtree the right subarray elements
    4. recurse
     */
    TreeNode createMinimalBST(int arr[], int start, int end){
        if(end < start) return null;

        int mid = (start + end) /2;
        TreeNode result = new TreeNode(arr[mid]);
        result.left = createMinimalBST(arr,start, mid-1);
        result.right = createMinimalBST(arr,mid+1, end);
        return result;
    }

    public static void main(String[] args){
        int[] nums = {3,5,9,11,13,17,21,25,30};
        MinimalTree mt = new MinimalTree();
        TreeNode result = mt.createMinimalBST(nums, 0, 8);
        result.print2D(result);
    }
}
