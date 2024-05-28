package leetCode.backTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Steps:
Choose: Make a choice for the next step towards a solution.
Explore: Explore all possible options from the current choice.
Evaluate: Determine if the current choice leads to a solution.
Backtrack: If the choice doesn’t lead to a solution, undo the choice and try another option.

Remember psudocode for backracking
void FIND_SOLUTIONS( parameters):
if (valid solution):
    store the solution
Return

for (all choice):
  if (valid choice):
    APPLY (choice)
    FIND_SOLUTIONS (parameters)
    BACKTRACK (remove choice)
Return
 */

public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> mappings= Map.of(2,"abc",3,"def",4,"ghi",5,"jkl",6,"mno",7,"pqrs",8,"tuv",9,"wxyz");
        char[] tmpCombination = new char[digits.length()];

        List<String> result = new ArrayList<>();
        StringBuilder input = new StringBuilder();
        int maximumLength= 0;

        for(int i= 0; i< digits.length();i++){
            String value = mappings.get(Integer.parseInt(""+digits.charAt(i)));
            input.append(value);
            if(i==0){
                maximumLength = value.length();
            }
        }

        backTrack(0,digits,result,input.toString(),maximumLength);
        return result;
    }

    void backTrack(Integer currentIndex, String digits, List<String> result, String input, int maximumLength){

    }

    public static void main(String[] args){

    }
}
