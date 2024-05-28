package leetCode.dynamic;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCosts = new int[cost.length];
        minCosts[0] = cost[0];
        minCosts[1] = cost[1];
        System.out.println(  "="+Arrays.toString(minCosts));
        for(int i=2; i< minCosts.length; i++){
            System.out.println(i + "b="+Arrays.toString(minCosts));
            int newCost1 = cost[i-1];
            int newCost2 = cost[i-2];

            minCosts[i] = cost[i] + Math.min(newCost1,newCost2);
            System.out.println(i + "="+Arrays.toString(minCosts));


        }


        return Math.min(minCosts[minCosts.length-1],minCosts[minCosts.length-2]);
    }

    public static void main(String[] args){
        int[] nums = {1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStairs mp = new MinCostClimbingStairs();
        System.out.println(mp.minCostClimbingStairs(nums));
    }
}
// if we start and index 0