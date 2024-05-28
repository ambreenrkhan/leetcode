package leetCode.arrayString;

public class GreatestCommonDivisor {
    public String gcdOfStrings(String str1, String str2) {

        String shorterStr = str1.length() <= str2.length() ? str1 : str2;
        String longerStr = str1.length() > str2.length() ? str1 : str2;

        int firstIndex = -1;

        boolean hasOccurances = false;
        while(true){
            int startIndex = !hasOccurances ? 0 : firstIndex+shorterStr.length();

            // No remainder
            if(startIndex == longerStr.length()){
                return shorterStr;
            }

            String remainderStr = longerStr.substring(startIndex+1);
            if(hasOccurances && !remainderStr.contains(shorterStr)){
                System.out.println(remainderStr + "="+shorterStr);

                if(remainderStr.length()<=shorterStr.length()){
                    System.out.println(remainderStr + "="+remainderStr.length()+ "====" + shorterStr + "="+shorterStr.length());
                    return remainderStr.substring(shorterStr.length());
                }else{
                    return remainderStr;
                }
            }

            firstIndex = longerStr.indexOf(shorterStr, startIndex);

            // no occurance at all
            if(firstIndex==-1 && !hasOccurances){
                return "";
            }

            hasOccurances = true;
        }
    }


    public static void main(String args[]){
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        System.out.println(gcd.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX","TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));

    }
}
