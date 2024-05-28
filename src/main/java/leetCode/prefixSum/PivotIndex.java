package leetCode.prefixSum;

import java.util.Arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {

        int leftSum = 0;
        int rightSum = Arrays.stream(nums,1,nums.length).sum();
        int pivot = 0; // first index

        if(leftSum == rightSum){
            return pivot;
        }


        for(int i=1;i< nums.length;i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {2,1,-1};
        PivotIndex pr = new PivotIndex();
        System.out.println(pr.pivotIndex(nums));
    }
}
