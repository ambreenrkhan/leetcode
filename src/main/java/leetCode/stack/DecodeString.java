package leetCode.stack;

import java.util.Objects;
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        if(Objects.isNull(s)) return "";

        Stack<String> stack = new Stack<>();
        Stack<Integer> numberOfTimes = new Stack<>();

        StringBuilder currentStr = new StringBuilder();
        StringBuilder currentNumber = new StringBuilder();


        for(int i =0; i< s.length(); i++){
            char currentChar = s.charAt(i);

            if(Character.isDigit(currentChar)){
                currentNumber.append(currentChar);
                if(currentStr.length()>0){
                    stack.push(currentStr.toString());
                }
                currentStr.setLength(0);
            }else if(Character.isAlphabetic(currentChar)){
                currentStr.append(currentChar);
            }else if(currentChar =='['){
                numberOfTimes.push(Integer.valueOf(currentNumber.toString()));
                currentNumber.setLength(0);
                stack.push(String.valueOf(currentChar));

            }else if(currentChar == ']'){
                if(currentStr.length()>0){
                    stack.push(currentStr.toString());
                }
                currentStr.setLength(0);
                currentNumber.setLength(0);

                StringBuilder repeaterSTr = new StringBuilder();
               if(!stack.isEmpty()){
                   String poppedChar = stack.pop();
                   while(!Objects.equals(poppedChar,"[")){
                       repeaterSTr.insert(0,poppedChar);
                       poppedChar = stack.pop();
                   }
               }

                if(!numberOfTimes.isEmpty()){
                    Integer times = numberOfTimes.pop();
                    stack.push(String.valueOf(repeaterSTr).repeat(times));
                }
            }
        }

        if(currentStr.length()>0){
            stack.push(currentStr.toString());
        }

        return String.join("", stack);
    }

    public static void main(String[] args){
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("2[abc]3[cd]ef"));
    }
}