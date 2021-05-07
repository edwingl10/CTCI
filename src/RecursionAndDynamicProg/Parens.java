package RecursionAndDynamicProg;

import java.util.ArrayList;

public class Parens {
    /**
     * Implement an algorithm to print all valid (i.e., properly opened and closed)
     * combinations of n pairs of parentheses.
     * EXAMPLE
     * Input: 3
     * OUTPUT: ((())), (()()), (())(), ()(()), ()()()
     */
    // keep track of the number of left and right parenthesis allowed. If there are let parens
    // remaining, we'll insert a left paren and recurse If there are more right parens remaining than left
    // then we'll insert a right paren and recurse
    public void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index){
        if(leftRem < 0 || rightRem < leftRem) return; // invalid state
        if(leftRem == 0&& rightRem == 0)
            list.add(String.copyValueOf(str));
        else{
            str[index] = '(';
            addParen(list, leftRem-1, rightRem, str, index+1);

            str[index] = ')';
            addParen(list, leftRem, rightRem-1, str, index+1);
        }
    }

    ArrayList<String> generateParens(int count){
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }
}
