package leetCode.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * BackTracking problems have four main parameters
 * 1. the final result set
 * 2. temporary holder to hold the current set
 * 3. all input numbers in array
 * 4. index from where to begin the loop for the given array
 * 5. any additional parameters to do with the combinations
 */

public class AllSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        backtrack(nums, 0, new LinkedList<>(), ans);
        return ans;
    }

    void backtrack(int[] nums, int i, List<Integer> cur, List<List<Integer>> ans){
        ans.add(new ArrayList<>(cur));
        for (int j = i; j<nums.length; j++){
            cur.add(nums[j]);
            backtrack(nums, j + 1, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
