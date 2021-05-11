package SortingAndSearching;

public class SortedMerge {
    /**
     * You are given two sorted arrays, A and B, where A has a large enough buffer
     * at the end to hold B. Write a method to merge B into A in sorted order.
     */
    void merge(int[] a, int[] b){
        int indexA = a.length - b.length -1;
        int indexB = b.length -1;
        int mergedIndex = a.length -1;

        while(indexB >= 0){
            if(b[indexB] > a[indexA]){
                a[mergedIndex] = b[indexB];
                indexB--;
            }
            else{
                a[mergedIndex] = a[indexA];
                indexA--;
            }
            mergedIndex--;
        }
    }

    public static void main(String[] args){
        SortedMerge s = new SortedMerge();
        int[] a = {3,6,11, 0, 0};
        int[] b = {5,10};

        s.merge(a,b);
        for(int item: a)
            System.out.println(item);
    }
}
