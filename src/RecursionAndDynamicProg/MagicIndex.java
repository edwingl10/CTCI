package RecursionAndDynamicProg;

public class MagicIndex {
    /**
     *  magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[i] = i.
     *  Given a sorted array of distinct integers, write a method to find a magic index,
     *  if one exists, in array A.
     */
    public int magicFast(int[] arr){
        return magicFast(arr, 0, arr.length-1);
    }

    int magicFast(int[] arr, int start, int end){
        if(end < start)
            return -1;

        int mid = (start+end)/2;
        if(mid == arr[mid])
            return mid;
        // if element larger than index, go left
        if(arr[mid] > mid)
            return magicFast(arr, start, mid-1);
        // if element smaller thn index, go right
        else return magicFast(arr, mid+1, end);
    }

    // if elements are not distinct
    int findMagic(int [] arr){
        return findMagic(arr, 0, arr.length-1);
    }
    int findMagic(int[] arr, int start, int end){
        if(end < start) return -1;

        int midIndex = (start+end)/2;
        int midValue = arr[midIndex];
        if(midValue == midIndex) return midIndex;

        // search left
        int leftIndex = Math.min(midIndex-1, midValue);
        int left = findMagic(arr, start, leftIndex);
        if(left >=0) return left;

        //search right
        int rightIndex = Math.max(midIndex+1, midValue);
        int right = findMagic(arr, rightIndex, end);
        return right;

    }


    public static void main(String[] args){
        MagicIndex m = new MagicIndex();
        int[] arr = {-40,-20,-1,1,2,3,5,7,9,12,13,14};
        System.out.println(m.magicFast(arr));

        int[] arr2 = {-10 -5, 2,2,2,3,4,7,9,12,13};
        System.out.println(m.findMagic(arr2));
    }
}
