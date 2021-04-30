package BitManipulation;

public class Insertion {
    /**
     * You are given two 32-bit numbers, N and M,  and two bit positions, i and j.
     * Write a method to insert M into N such that M starts at bit j and ends at bit i.
     * You can assume that the bits j through i have enough space to fit all of M.
     * That is, if M = 10011, you can assume that there are at least 5 bits between j  and i.
     * You would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
     */

    /*
    1. clear the bits j through i in N
    2. Shift M so that it lines up with bits j through i
    3. Merge M and N
     */
    int updateBits(int n, int m, int i, int j){
        // create a mask to clear bits i through j in n.
        int allOnes = ~0;
        // 1s before position j, then 0s.
        int left = allOnes << (j+1);
        // 1s after position i.
        int right = ((1 << i) -1);
        // all 1s, except for 0s between i and j.
        int mask = right | left;
        //clear bits j through i then put m in there
        int n_cleared = n & mask;
        int m_shifted = m << i;

        return n_cleared | m_shifted;
    }

    public static void main(String[] args){
        Insertion i = new Insertion();
        int result = i.updateBits(32, 12, 1, 4);
        System.out.println(result);
    }

}
