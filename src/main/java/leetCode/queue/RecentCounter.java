package leetCode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> recentCalls;

    public RecentCounter() {
        recentCalls = new LinkedList<>();
    }

    public int ping(int t) {
        while(true){
            Integer head = recentCalls.peek();
            if(recentCalls.isEmpty() || t-head<=3000){
                break;
            }
            recentCalls.poll();
        }
        recentCalls.add(t);
        return recentCalls.size();
    }

    public static void main(String[] args){
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));

    }
}
