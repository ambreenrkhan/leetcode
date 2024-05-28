package leetCode;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {
    public static int removeDuplicates(int[] nums) {
        int currentInsertionIndex = 0;

        for(int i = 0; i<nums.length;i++){
            String before = Arrays.toString(nums);

            if(i < 2){
                ++currentInsertionIndex;
            }else if ((currentInsertionIndex>1) && (nums[i] ==  nums[currentInsertionIndex-1]) && (nums[i]==nums[currentInsertionIndex-2])){
            }
            else{
                nums[currentInsertionIndex] = nums[i];
                ++currentInsertionIndex;

            }
        }

        return currentInsertionIndex;
    }


    public static void main(String args[]){
        int[] input = {0,0,1,1,1,1,2,3,3};

        //int[] input = {1,1,1,2,2,3};

        System.out.println(removeDuplicates(input));
        System.out.println(Arrays.toString(input));
    }
}
