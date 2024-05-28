package leetCode.slidingWindow;

public class MaxVowels {
    public int maxVowels(String s, int k) {
        int maxVowels =0;
        int runningVowels = 0;
        int windowStart = 0;

        boolean[] vowel = new boolean[s.length()];
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(i>=k){
                windowStart++;
            }

            boolean isVowel = isVowel(ch);
            vowel[i] = isVowel;

            if(isVowel) {
                runningVowels++;
            }

            if(windowStart >0 && vowel[windowStart - 1]){
                runningVowels--;
            }
            maxVowels = Math.max(maxVowels,runningVowels);
        }

        return maxVowels;
    }


    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch =='i' ||ch =='o' || ch =='u';
    }

    public static void main(String[] args){
        MaxVowels mv = new MaxVowels();
        System.out.println(mv.maxVowels("leetcode",3));
    }
}
