package leetCode.arrayString;

public class ReverseVowels {
    public String reverseVowels(String s) {
        if(s == null || s.trim().length() == 0) return s;

        char[] charArray = s.toCharArray();

        int startSwap = 0;
        int endSwap = charArray.length-1;

        boolean swapRequiredStart = false;
        boolean swapRequiredEnd = false;

        int index = 0;

        while(startSwap<endSwap && index<charArray.length){

            if(!swapRequiredStart && isVowel(charArray[startSwap])){
                swapRequiredStart = true;
            }

            if(!swapRequiredEnd && isVowel(charArray[endSwap])){
                swapRequiredEnd = true;
            }

            if(swapRequiredStart && swapRequiredEnd){
                char tmp = charArray[startSwap];
                charArray[startSwap] = charArray[endSwap];
                charArray[endSwap] = tmp;

                swapRequiredStart = false;
                swapRequiredEnd = false;
                startSwap++;
                endSwap--;
            }else{
                if(!swapRequiredStart)startSwap++;
                if(!swapRequiredEnd)endSwap--;

            }

            index++;
        }


        return String.valueOf(charArray);
    }

    private boolean isVowel(char charToCheck){
        return charToCheck == 'a' || charToCheck == 'A' || charToCheck == 'E' || charToCheck == 'e' || charToCheck == 'I' || charToCheck == 'i' || charToCheck == 'O' || charToCheck == 'o' || charToCheck == 'U' || charToCheck == 'u';
    }

    public static void main(String[] args){
        ReverseVowels rq = new ReverseVowels();
        System.out.println(rq.reverseVowels("Euston saw I was not Sue."));
    }


}



//Euston saw I was not Sue.
//eustun sow a wIs nat SoE.
//euston saw I was not SuE.
