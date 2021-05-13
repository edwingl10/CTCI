package SortingAndSearching;

public class SparseSearch {
    /**
     * Given a  sorted array of strings that is interspersed with empty strings,
     * write a method to find the location of a given string.
     * EXAMPLE
     * input: ball, {"at", "","","","ball","","","car","","","dad","",""}
     * output: 4
     */

    int search(String[] strings, String str, int first, int last){
        if(first > last) return -1;
        // move mid to middle
        int mid = (last+first)/2;

        // if mid is empty, find closest non-empty string
        if(strings[mid].isEmpty()){
            int left = mid-1;
            int right = mid+1;
            while(true){
                if(left < first && right > last)
                    return -1;
                else if(right <= last && !strings[right].isEmpty()){
                    mid = right;
                    break;
                }
                else if(left >= first && !strings[left].isEmpty()){
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }

        //check for string, and recurse if necessary
        if(str.equals(strings[mid]))
            return mid;
        else if(strings[mid].compareTo(str) < 0) // search right
            return search(strings, str, mid+1, last);
        else
            return search(strings, str, first, mid-1);
    }

    public int search(String[] strings, String str){
        if(strings == null || str == null || str == "")
            return -1;
        return search(strings, str, 0, strings.length-1);
    }


    public static void main(String[] args){
        SparseSearch s = new SparseSearch();
        String[] strings = {"at","","","","ball","","","car","","","dad","",""};
        System.out.println(s.search(strings, "ball"));
    }
}
