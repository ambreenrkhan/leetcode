package leetCode.arrayString;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int length = Math.min(word1.length(),word2.length());
        StringBuilder sb = new StringBuilder();

        for(int i= 0 ;i < length;i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if(word1.length() > length){
            sb.append(word1.substring(length));
        }else if(word2.length() > length){
            sb.append(word2.substring(length));
        }

        return sb.toString();
    }

    public static void main(String[] args){
        MergeStringsAlternately ms = new MergeStringsAlternately();
        System.out.println(ms.mergeAlternately("abcd","pq"));
    }
}
