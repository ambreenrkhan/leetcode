package leetCode.arrayString;

/**
 * This is an expensive approach.. use a char array to reverse instead
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        if(s== null || s.length() == 0){
            return s;
        }

        String reversedStr = "";
        String word = "";

        for(int i = 0; i < s.length() ; i++){
            if(!Character.isWhitespace(s.charAt(i))){
                word = word+s.charAt(i);
            }else{
                if(word.length()!=0){
                    reversedStr = word + (reversedStr.length() == 0 ? "": " " )+ reversedStr;
                    word = "";
                }
            }
        }

        if(!word.isEmpty()){
            reversedStr = word +(reversedStr.length() == 0 ? "": " " )+ reversedStr;
        }

        return reversedStr;
    }

    public static void main(String args[]){
        System.out.println("->"+reverseWords("  hello world  ")+"<--");
    }

}


