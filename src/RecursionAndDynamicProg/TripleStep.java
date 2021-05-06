package RecursionAndDynamicProg;

import java.util.Arrays;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
// runtime is O(3^n)
public class TripleStep {

    public int countWays(int steps){
        if(steps == 0) return 1;
        if(steps < 0) return 0;
        return countWays(steps-1) + countWays(steps-2) + countWays(steps-3);
    }

    // memoization solution
    public int countWayz(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWayz(n, memo);
    }
    public int countWayz(int n, int[] memo){
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(memo[n] > -1)
            return memo[n];

        memo[n] = countWayz(n-1, memo) + countWayz(n-2, memo) + countWayz(n-3, memo);
        return memo[n];
    }

    public static void main(String[] args){
        TripleStep t = new TripleStep();
        int result = t.countWays(5);
        System.out.println(result);
    }
}
