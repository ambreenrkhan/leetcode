package leetCode.twoPointer;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length<2) return;

        int i= 0;
        int j= 1;

        while(j< nums.length){
            int numI = nums[i];
            int numJ = nums[j];

            if(numI==0 && numJ!=0){
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }else if(numI!=0){
                i++;
            }

            j++;
        }
    }

    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
