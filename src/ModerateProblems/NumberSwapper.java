package ModerateProblems;

public class NumberSwapper {
    /**
     * Write a function to swap a number in place (that is, without temporary variables)
     */

    // uses the number approach
    public void numSwap (int a, int b){
        a = a-b;
        b=a+b;
        a=b-a;

        System.out.format("a: %d  b: %d \n", a, b);
    }

    // uses XOR
    public void bitSwap(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;

        System.out.format("a: %d  b: %d", a, b);
    }

    public static void main(String[] args){
        NumberSwapper n = new NumberSwapper();
        int a = 9;
        int b = 4;

        n.numSwap(a,b);
        n.bitSwap(a,b);
    }
}
