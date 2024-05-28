package leetCode.slidingWindow;

public class MaxAverageSubArray {
    public double findMaxAverage(int[] nums, int k) {
        if(k==0 || nums == null) return 0;

        double maxAverage = Double.MIN_VALUE;
        double runningSum = 0;
        for(int i = 0; i<nums.length;i++){
            runningSum += nums[i];
            if(i>=k && (i-k)>=0){
               runningSum -= nums[i-k] ;
            }
            if(i>=k-1){
                double currentAverage = runningSum/k;
                maxAverage = (maxAverage == Double.MIN_VALUE) ? currentAverage : Math.max(maxAverage, currentAverage);
            }
        }

        return maxAverage;
    }

    public static void main(String[] args){
        MaxAverageSubArray maxAverageSubArray = new MaxAverageSubArray();
        int[] nums = {-1};
        System.out.println(maxAverageSubArray.findMaxAverage(nums,1));
    }
}
