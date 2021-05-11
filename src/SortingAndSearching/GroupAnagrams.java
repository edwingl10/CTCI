package SortingAndSearching;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class AnagramComparator implements Comparator<String> {
    public String sortChars(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public int compare(String s1, String s2){
        return sortChars(s1).compareTo(sortChars(s2));
    }
}


public class GroupAnagrams {
    /**
     * Write a method to sort an array of strings so that all tne anagrams are next to each other.
     */
    public void sort(String[] array){
        HashMapList<String, String> mapList = new HashMapList<String, String>();

        for(String s: array){
            String key = sortChars(s);
            mapList.put(key, s);
        }

        // convert hash table to array
        int index = 0;
        for(String key: mapList.keySet()){
            ArrayList<String> list = mapList.get(key);
            for(String t:list){
                array[index] = t;
                index++;
            }
        }
    }

    public String sortChars(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static void main(String[] args){
        GroupAnagrams g = new GroupAnagrams();
        String[] a = {"apt", "ear", "pat", "tap","are","era"};
    }
}
