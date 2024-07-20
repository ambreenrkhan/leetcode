package leetCode.dynamic;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCosts = new int[cost.length];

        minCosts[0] = cost[0];
        minCosts[1] = cost[1];

        for(int i=2; i<cost.length; i++){
            minCosts[i] = cost[i]+Math.min(minCosts[i-1],minCosts[i-2]);
        }

        return Math.min(minCosts[cost.length-1],minCosts[cost.length-2]);
    }

    public static void main(String[] args){
        int[] nums = {1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStairs mp = new MinCostClimbingStairs();
        System.out.println(mp.minCostClimbingStairs(nums));
    }
}