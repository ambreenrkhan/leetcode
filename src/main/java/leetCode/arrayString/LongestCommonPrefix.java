package leetCode.arrayString;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if(strs == null || strs.length == 0){
            return prefix.toString();
        }

        if(strs.length == 1){
            return strs[0];
        }

        for(int index = 0; index < strs[0].length(); index++){
            char currentChar = strs[0].charAt(index);
            if(checkExpectedCharacter(strs, index, currentChar)){
                prefix.append(currentChar);
            }else{
                break;
            }
        }

        return prefix.toString();
    }

    private boolean checkExpectedCharacter(String[] strs, int index, char expectedChar){
        for(int i=1; i< strs.length; i++){
            if(strs[i].length()<=index || strs[i].charAt(index) != expectedChar){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        var lcp = new LongestCommonPrefix();
        String[] strs = {"ab","a"};
        System.out.println(lcp.longestCommonPrefix(strs));
    }
}
