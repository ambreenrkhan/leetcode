package leetCode.twoPointer;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t ==null) return false;
        if(s.isEmpty() ) return true;
        int sIndex=0;

        for(int tIndex=0; tIndex<t.length();tIndex++){
            System.out.println(s.charAt(sIndex) +"="+ t.charAt(tIndex));
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
            }
            if(sIndex == s.length()){
               break;
            }

        }

        return sIndex == s.length();
    }

    public static void main(String[] args){
        IsSubsequence is = new IsSubsequence();
        System.out.println(is.isSubsequence("b","abc"));
    }
}
