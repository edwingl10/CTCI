package SortingAndSearching;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;


public class GroupAnagrams {
    /**
     * Write a method to sort an array of strings so that all tne anagrams are next to each other.
     */

    public void sortChars(String[] array){
        HashMap<String, LinkedList<String>> list = new HashMap<String, LinkedList<String>>();

        for(String s: array){
            String key = sortChars(s);
            if(!list.containsKey(key)){
                list.put(key, new LinkedList<String>());
            }
            LinkedList<String> anagrams = list.get(key);
            anagrams.push(s);
        }

        int index = 0;
        for(String key: list.keySet()){
            LinkedList<String> anagrams = list.get(key);
            for(String val: anagrams){
                array[index] = val;
                index++;
            }
        }
    }

    String sortChars(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static void main(String[] args){
        GroupAnagrams g = new GroupAnagrams();
        String[] a = {"apt", "ear", "pat", "tap","are","era"};
        g.sortChars(a);

        for(String s: a)
            System.out.println(s);
    }
}
