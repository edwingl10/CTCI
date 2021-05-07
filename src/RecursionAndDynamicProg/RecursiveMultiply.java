package RecursionAndDynamicProg;

public class RecursiveMultiply {
    /**
     * Write a  recursive function to multiply two positive integers
     * without using the * operator (or / operator). You can use addition, subtraction, and bit shifting,
     * but you should minimize the number of those operations.
     */
    int mult(int n, int n2){
        return mult(0, n, n2);
    }
    int mult(int result, int n, int n2){
        if(n2 == 0) return result;
        result += n;
        return mult(result, n, n2-1);
    }

    public static void main(String[] args){
        RecursiveMultiply r = new RecursiveMultiply();
        System.out.println(r.mult(5,3));
    }
}
