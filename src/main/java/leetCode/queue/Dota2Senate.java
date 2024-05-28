package leetCode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();

        for(int i=0;i<senate.length();i++){
            Character party = senate.charAt(i);
            queue.add(party);
        }
        return null;
    }

    public static void main(String[] args){
        Dota2Senate dota2Senate = new Dota2Senate();

    }
}
