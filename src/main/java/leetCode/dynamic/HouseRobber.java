package leetCode.dynamic;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        if(nums.length==1){
            return nums[0];
        }

        int[] money = new int[nums.length+1];
        money[0] = 0;
        money[1] = nums[0];

        for(int i=1; i<nums.length; i++){
            money[i+1] = Math.max(money[i], nums[i] + money[i-1]);
        }

        return money[nums.length];
    }

    public static void main(String[] args){
        var hr = new HouseRobber();
        int[] nums = {1,1};
        System.out.println(hr.rob(nums));
    }

}
