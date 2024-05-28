package leetCode.prefixSum;

import java.util.Objects;

public class HighestAltitude {
    public int largestAltitude(int[] gain) {
        if(Objects.isNull(gain)) return 0;

        int currentAltitude = gain[0];
        int highestAltitude = Math.max(gain[0], 0);

        for(int i = 1; i<gain.length;i++){
            currentAltitude = currentAltitude+gain[i];
            highestAltitude = Math.max(highestAltitude,currentAltitude);
        }
        return highestAltitude;
    }

    public static void main(String[] args){
        HighestAltitude ha =  new HighestAltitude();
        int[] gain= {-5,1,5,0,-7};
        System.out.println(ha.largestAltitude(gain));
    }
}
