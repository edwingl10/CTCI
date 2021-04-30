package BitManipulation;

public class Conversion {
    /**
     * Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
     * EXAMPLE
     * Input: 29 (11101), 15 (01111)
     * Output: 2
     */

    /*
    XOR both numbers to figure out which bits are different
    count and return the number of bits in A^B that are 1
     */
    int bitSwapRequired(int a, int b){
        int count = 0;
        int diff = a ^ b;

        while(diff != 0){
            if((diff&1) == 1)
                count++;
            diff >>>= 1;
        }

        return count;
    }

    int bitSwap(int a, int b){
        int count = 0;
        for(int c=a^b; c!=0; c=c&(c-1))
            count++;
        return count;
    }

    public static void main(String[] args){
        Conversion conv = new Conversion();

        System.out.println(conv.bitSwapRequired(29, 15));
    }
}
