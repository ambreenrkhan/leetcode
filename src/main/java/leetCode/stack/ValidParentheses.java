package leetCode.stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s ==null || s.length() == 0) return false;

        Stack<Character> openBrackets = new Stack<>();

        for(int index = 0; index < s.length(); index++){
            char currentBracket = s.charAt(index);
            if(isOpenBracket(currentBracket)){
                openBrackets.push(currentBracket);
            }else{
                Character expectedOpenBracketToClose = getOpeningBracket(currentBracket);
                if(expectedOpenBracketToClose == null || openBrackets.isEmpty() || openBrackets.pop() != expectedOpenBracketToClose){
                    return false;
                }
            }
        }

        return openBrackets.isEmpty();
    }

    private boolean isOpenBracket(char currentChar){
        return currentChar == '{' || currentChar == '[' || currentChar == '(';
    }

    private Character getOpeningBracket(char closingBracket){
        if(closingBracket == ']'){
            return '[';
        }

        if(closingBracket == '}'){
            return '{';
        }

        if(closingBracket == ')'){
            return '(';
        }

        return null;
    }

    public static void main(String[] args){
        var vp = new ValidParentheses();
        System.out.println(vp.isValid("()"));
        System.out.println(vp.isValid("()[]{}"));
        System.out.println(vp.isValid("(]"));

    }

}
