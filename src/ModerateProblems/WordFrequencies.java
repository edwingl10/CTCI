package ModerateProblems;


import java.util.HashMap;

public class WordFrequencies {
    /**
     * Design a method to find the frequency of occurences of any given word in a book. What if we were running
     * this algorithm multiple times?
     */

    HashMap<String, Integer> setupDictionary(String[] book){
        HashMap<String, Integer> table = new HashMap<String, Integer>();
        for(String word : book){
            word = word.toLowerCase();
            if(word.trim() != ""){
                if(!table.containsKey(word))
                    table.put(word, 0);
            }
            table.put(word, table.get(word) +1);
        }
        return table;
    }

    int getFrequency(HashMap<String, Integer> table, String word){
        if(table == null || word == null) return -1;
        word = word.toLowerCase();
        if(table.containsKey(word))
            return table.get(word);

        return 0;
    }

    public static void main(String[] args){
        WordFrequencies w = new WordFrequencies();
        String[] book = "hello there this is just a test to see how this works hello just a test hello".split(" ");
        HashMap<String, Integer> table = w.setupDictionary(book);

        System.out.println(w.getFrequency(table, "test"));
    }
}
