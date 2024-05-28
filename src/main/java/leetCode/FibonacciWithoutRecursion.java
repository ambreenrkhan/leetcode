package leetCode;

import java.util.Arrays;

public class FibonacciWithoutRecursion {

    public long calculate(int n){
        // time and space complexity O(n)
        long[] calculatedValues = new long[n+1];
        for(int i = 1 ; i<= n; i++){
            calculatedValues[i] = (i>=3) ? (calculatedValues[i-1] + calculatedValues[i-2]) : i;
        }


        System.out.println(Arrays.toString(calculatedValues));
        return calculatedValues[calculatedValues.length-1];
    }

    public static void main(String args[]){
        FibonacciWithoutRecursion fbr = new FibonacciWithoutRecursion();
        System.out.println(fbr.calculate(8));
    }
}
