package RecursionAndDynamicProg;

import java.util.ArrayList;

public class PermutationWithoutDups {
    /**
     * Write a method to compute all permutations of a string of unique characters.
     */
    ArrayList<String> getPerms(String str){
        if(str == null) return null;

        ArrayList<String> permutation = new ArrayList<String>();
        if(str.length() == 0) {
            permutation.add("");
            return permutation;
        }
        char first = str.charAt(0); // get the first char
        String remainder = str.substring(1); //remove the first char
        ArrayList<String> words = getPerms(remainder);
        for(String word:words){
            for(int j=0; j<=word.length(); j++){
                String s = insertCharAt(word, first, j);
                permutation.add(s);
            }
        }
        return permutation;
    }

    String insertCharAt(String word, char c, int i ){
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void main(String[] args){
        PermutationWithoutDups p = new PermutationWithoutDups();
        ArrayList<String> result = p.getPerms("abc");

        System.out.println(result.toString());
    }
}
