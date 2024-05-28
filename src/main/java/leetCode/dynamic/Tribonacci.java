package leetCode.dynamic;


public class Tribonacci {

    public int tribonacci(int n) {
        if(n<3){
            return n ==0 ? 0 : 1;
        }

        int[] calculatedNums = new int[n];
        calculatedNums[0] = 0;
        calculatedNums[1] = 1;
        calculatedNums[2] = 1;

        for(int i = 3; i<n; i++){
            calculatedNums[i] = calculatedNums[i-2]+calculatedNums[i-1]+calculatedNums[i-3];
        }

        return calculatedNums[n-1]+calculatedNums[n-2]+calculatedNums[n-3];
    }

    public static void main(String[] args){
        Tribonacci tribonacci = new Tribonacci();
        System.out.println(tribonacci.tribonacci(25));
    }
}
