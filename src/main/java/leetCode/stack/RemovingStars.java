package leetCode.stack;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemovingStars {

    public String removeStars(String s) {
        if(Objects.isNull(s)) return "";

        char star = '*';
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i< s.length() ; i++){
            char currentChar =  s.charAt(i);
            if(currentChar == star){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(currentChar);
            }
        }
        return stack.stream().map(Object::toString).collect(Collectors.joining());
    }

    public static void main(String[] args){
        RemovingStars rs = new RemovingStars();
        System.out.println(rs.removeStars("leet**cod*e"));
    }
}
