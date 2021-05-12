package SortingAndSearching;

public class SearchInRotatedArray {
    /**
     * Given a sorted array of n integers that has been rotated an unknown number of times,
     * write code to find an element in the array. You may assume that the array was originally
     * sorted in increasing order.
     * EXAMPLE
     * Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
     * Output: 8 (the index of 5 in the array)
     */

    // runs in O(log n) if all elements are unique
    // if many duplicates will run in O(n), we will often search both left and right sides of array
    public int search(int a[], int left , int right, int x){
        int middle = (left+right)/2;
        if (a[middle] == x) return middle;
        if(right < left) return -1;

        if(a[left] < a[middle]){ //left is normally ordered
            if(x >= a[left] && x < a[middle])
                return search(a, left, middle-1, x); //search left
            else
                return search(a, middle+1, right, x); // search right
        }
        // right is normally ordered
        else if(a[middle] < a[left]){
            if(x > a[middle] && x <= a[right]) // search right
                return search(a, middle+1, right, x);
            else
                return search(a, left, middle-1, x); // search left
        }
        // left or rght half is all repeats
        else if(a[left] == a[middle]){
            //if right is different search it
            if(a[middle] != a[right])
                return search(a, middle+1, right, x);
            else{
                int result = search(a, left, middle-1, x); // search left
                if(result == -1)
                    return search(a, middle+1, right, x); // search right
                else
                    return result;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        SearchInRotatedArray s = new SearchInRotatedArray();

        int[] arr1 = {10, 15, 20, 0, 5};
        int[] arr2 = {50, 5, 20, 30, 40};
        int[] arr3 = {2,2,2,3,4,2};

        System.out.println(s.search(arr1, 0, 4, 5));
        System.out.println(s.search(arr2, 0, 4, 5));
        System.out.println(s.search(arr3, 0, 4, 5));
    }
}
