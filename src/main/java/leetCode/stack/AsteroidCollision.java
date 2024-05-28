package leetCode.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
       if(Objects.isNull(asteroids)) return null;

        Stack<Integer> results = new Stack<>();

        for (int a : asteroids) {
            if (a > 0) {
                results.push(a);
            } else {
                while (!results.isEmpty() && results.peek() > 0 && results.peek() < -a) {
                    results.pop();
                }

                if (results.isEmpty() || results.peek() < 0)  {
                    results.push(a);
                }

                if (results.peek() == -a) {
                    results.pop();
                }
            }
        }

        int[] finalRes = new int[results.size()];
        int index = results.size() - 1;

        while(!results.isEmpty()) {
            finalRes[index--] = results.pop();
        }

        return finalRes;
    }

    public static void main(String[] args){
        AsteroidCollision ac = new AsteroidCollision();
        int[] as ={-2,-1,1,2};
        System.out.println(Arrays.toString(ac.asteroidCollision(as)));
    }
}
