package SortingAndSearching;

public class PeaksAndValleys {
    /**
     * In an array of integers, a "peak" is an element which is greater than or equal to
     * the adjacent integers and a "valley" is an element which is less than or equal to the adjacent integers.
     * For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys.
     * Given an array of integers, sort the array into an alternating sequence of peaks and valleys.
     * EXAMPLE
     * Input: {5,3,1,2,3}
     * Ouput: {5,1,3,2,3}
     */

    /*
    //takes =O(N) time
    void sortValleyPeak(int[] arr){
        for(int i=1; i<arr.length; i+=2){
            int biggestIndex = maxIndex(arr, i-1, i, i+1);
            if(i != biggestIndex)
                swap(arr, i, biggestIndex);
        }
    }

    int maxIndex(int[] arr, int a, int b, int c){
        int len = arr.length;
        int aValue = a>=0 && a<len ? arr[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? arr[b]: Integer.MIN_VALUE;
        int cValue = c >=0 && c < len? arr[c]: Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));
        if(aValue == max) return a;
        else if(bValue == max) return b;
        return c;
    } */
    
}
