package leetCode.arrayString;

public class StringRotation {

    public static boolean isRotatedString(String s1, String s2){
        if(s1 == null || s2 ==null || s1.length()!=s2.length()){
            return false;
        }

        String newStr = s1+s1;
        return newStr.contains(s2);
    }

    public static void main(String[] args){
        System.out.println(isRotatedString("waterbottle", "erbottlewat"));
    }

}
