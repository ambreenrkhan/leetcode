package leetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] input = {1,2,3,4,5,6,7,8,9};

        List<List<Integer>> result = new ArrayList<>();
        calculate(result, new ArrayList<>(), 0, input, k, n);

        return result;
    }

    private void calculate(List<List<Integer>> result, List<Integer> tmp, int index, int[] input, int totalNumbers, int remainingTarget){
        if(remainingTarget == 0 && tmp.size() == totalNumbers){ // CONDITION (MET) - actual limits check
            result.add(new ArrayList<>(tmp));
            return;
        }

        for(int j=index; j<input.length;j++){
            int num = input[j];

            if(remainingTarget-num>=0 && tmp.size()<=totalNumbers){ // CONDITION (CHECK) -- still scope
                tmp.add(num);
                calculate(result, tmp, j+1,input,totalNumbers,remainingTarget-num);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static void main(String[] args){
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum3(4,1));

    }
}
