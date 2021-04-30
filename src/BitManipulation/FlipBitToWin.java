package BitManipulation;

public class FlipBitToWin {
    /**
     * You have an integer and you can flip exactly one bit from a O to a  1.
     * Write code to find the length of the longest sequence of 1 s  you could create.
     * EXAMPLE:
     * Input: 1775 (or: 11011101111)
     * Output: 8
     */

    int flipBit(int a){
        // if all 1s, this is already the longest sequence
        if(~a == 0) return Integer.BYTES * 8;

        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1; // we can always have a sequence of at least one 1
        while(a != 0){
            if((a&1) == 1) //current bit is a 1
                currentLength++;
            else if((a&1) == 0){ //current bit is 0
                //update to o (if nxt bit is 0) or currentLength (if next bit is 1)
                previousLength = (a & 2) == 0? 0:currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(previousLength + currentLength +1 , maxLength);
            a >>>=1;
        }
        return maxLength;
    }

    public static void main(String[] args){
        FlipBitToWin f = new FlipBitToWin();
        System.out.println(f.flipBit(1775));
    }

}
