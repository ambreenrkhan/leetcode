package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".  [ S : ADOBECODEBANC | T :"ABC" ] -> BANC
 */
public class MinimumWindowSubstring {


    public static String minWindow(String s, String t) {

        if(t.length()>s.length()) return "";
        String slidingWindowString = "";

        List<Character> expectedCharacters = new ArrayList<>();
        List<Boolean> charFoundInSlidingWindow = new ArrayList<>();

        for(int i = 0; i< t.length(); i++){
            expectedCharacters.add(t.charAt(i));
            charFoundInSlidingWindow.add(false);
        }

        int currentStartingIndex = -1;
        int currentEndingIndex = -1;

        // always first strategy is to create the initial sliding window
        int numOfCharactersFound = 0;
        for(int i = 0; i< s.length();i++){
            char currentChar = s.charAt(i);
            int trackingIndex =  expectedCharacters.indexOf(currentChar);

            if(trackingIndex!=-1){
                charFoundInSlidingWindow.set(trackingIndex,true);
                numOfCharactersFound++;

                if(currentStartingIndex==-1){
                    currentStartingIndex = i;
                }

                currentEndingIndex = i;

            }

        }

        int indexOfFirstChar = -1;
        char firstChar = 0;

        return null;
    }

    private class CharacterInfo{
        int expectedNumber;
        int currentIndex;

        public CharacterInfo(int currentIndex){
         expectedNumber = 1;
         this.currentIndex = currentIndex;
        }

        void incrementCount(){
            expectedNumber++;
        }

        public void setCurrentIndex(int index){
            this.currentIndex = index;
        }

    }

    public static void main(String args[]){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
