package RecursionAndDynamicProg;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
public class TripleStep {

    public int countWays(int steps){
        if(steps == 0) return 1;
        if(steps < 0) return 0;
        return countWays(steps-1) + countWays(steps-2) + countWays(steps-3);
    }

    public static void main(String[] args){
        TripleStep t = new TripleStep();
        int result = t.countWays(5);
        System.out.println(result);
    }
}
