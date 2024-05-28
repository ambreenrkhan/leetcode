package leetCode.dynamic;

/**
 * This is an example of dynamic problem.
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * let ways[i] represent ways to reach stair-case i
 * then this will be ways[i]= ways[i-1] + ways[i-2]
 *
 * 1. now initialize an array with an extra state to store state 0 as well (pretty common in DP problems to store this extra state)
 * 2. calculate the obvious basic cases
 * 3. now calculate the rest of the cases using an iterative approach
 */
public class StaircaseProblem {
    public static int numberOfWays(int n){
        int[] ways = new int[n+1];

        ways[0] = 1;
        ways[1] = 1;

        for(int i = 2; i<=n; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }

        return ways[n];
    }

    public static void main(String args[]){
        System.out.println(numberOfWays(7));
    }
}
