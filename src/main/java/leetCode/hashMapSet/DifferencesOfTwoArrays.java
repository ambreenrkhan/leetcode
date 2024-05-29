package leetCode.hashMapSet;

import java.util.*;
import java.util.stream.Collectors;

public class DifferencesOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> num1Map = new HashMap<>();
        Map<Integer, Boolean> nums2Map = new HashMap<>();

        for(int num : nums1){
            num1Map.put(num, true);
        }

        for(int num : nums2){
            if(!num1Map.containsKey(num)){
                nums2Map.put(num, true);
            }else{
                num1Map.put(num, false);
            }
        }

        List<Integer> finalNum1 = num1Map.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).collect(Collectors.toList());
        return Arrays.asList(finalNum1, new ArrayList<>(nums2Map.keySet()));
    }


    public static void main(String[] args){
        DifferencesOfTwoArrays da = new DifferencesOfTwoArrays();
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};

        System.out.println(da.findDifference(nums1,nums2));
    }
}
