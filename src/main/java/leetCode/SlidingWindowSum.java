package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers of size ‘n’.
 * Our aim is to calculate the maximum sum possible for ‘k’ consecutive elements in the array.
 * Input  : arr[] = {100, 200, 300, 400}
 *          k = 2
 * Output : 700
 */
public class SlidingWindowSum {
    public static long calculateSum(int[] arr, int k){

        if( k > arr.length) return 0;
        // calculate the sum of the first window
        long slidingWindowSum = 0;
        for(int i = 0;i<k;i++){
            slidingWindowSum += arr[i];
        }

        if(k == arr.length) return slidingWindowSum;
        long maximumSum = slidingWindowSum;

        for(int i = k ; i < arr.length; i++){
            long currentSum = slidingWindowSum + arr[i] - arr[i-k];
            maximumSum = Math.max(maximumSum,currentSum);
            slidingWindowSum = currentSum;
        }

        return maximumSum;
    }

    public static void main(String args[]){
        int arr[] = {100, 200, 300, 400};
        System.out.println(calculateSum(arr,2));
    }

}
