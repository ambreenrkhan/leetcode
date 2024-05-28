package leetCode.hashMapSet;

import java.util.*;

public class UniqueNumberOfInstances {
    public boolean uniqueOccurrences(int[] arr) {
        if(arr == null || arr.length == 0) return false;

        Map<Integer,Integer> freqCount = new HashMap<>();

        Arrays.stream(arr).forEach(x-> freqCount.merge(x, 1, Integer::sum));

        Set<Integer> uniqueCounts = new HashSet<>(freqCount.values());
        return uniqueCounts.size() == freqCount.size();
    }

    public static void main(String[] args){
        UniqueNumberOfInstances numberOfInstances = new UniqueNumberOfInstances();
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(numberOfInstances.uniqueOccurrences(arr));
    }
}
