package leetCode.arrayString;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if(n==0) return;

        if(m==0){
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
           return;
        }

        int nums1IndexSpare = nums1.length - 1;
        int nums1IndexCurrent = m-1;
        int current = nums1[nums1IndexCurrent];

        for(int i =n-1; i >=0 ; i--){
            int candidate = nums2[i];
            System.out.println(Arrays.toString(nums1) + "candidate"+candidate);

            if(candidate > current ) { // this is the highest number
                nums1[nums1IndexSpare] = candidate;
                --nums1IndexSpare;
            }else{
                // so you have to shift all current unless you find the index of insertion


                while(candidate <= current){
                    nums1[nums1IndexSpare] = nums1[nums1IndexCurrent];
                    --nums1IndexSpare;
                    --nums1IndexCurrent;
                    if(nums1IndexCurrent>=0){
                        current = nums1[nums1IndexCurrent];
                    }

                    if((nums1IndexSpare <0) ||(nums1IndexCurrent <0) ){
                     break;
                    }
                }
                nums1[nums1IndexCurrent+1] = candidate;
            }
        }
    }

    public static void main(String args[]){

        int[] nums1 = {4,5,6,0,0,0}; // non-descending sorted array
        int[] nums2 = {1,2,3}; // non-descending sorted array
        merge(nums1,3,nums2,3);

//        int[]  nums1 = {2,0}; // non-descending sorted array
//        int[]  nums2 = {1}; // non-descending sorted array
//        merge(nums1,1,nums2,1);
        System.out.println(Arrays.toString(nums1));
    }
}
