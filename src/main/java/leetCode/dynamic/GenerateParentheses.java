package leetCode.dynamic;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        if(n==1){
            result.add("()");
            return result;
        }

        List<String> existingParans = generateParenthesis(--n);
        for(String existingParan : existingParans){
            for(int i=0;i < existingParan.length(); i++){
                String begin = existingParan.substring(0,i);
                String end = existingParan.substring(i);
                String newStr = begin+"()"+end;
                if(!result.contains(newStr)){
                    result.add(newStr);
                }
            }
        }

        return result;

    }
}
