package leetCode.dynamic;

import java.util.Arrays;

public class CoinsChange {
    public int change(int amount, int[] coins) {
        int[] allAmounts = new int[amount+1];
        allAmounts[0] = 1;

        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (coin <= j) {
                    allAmounts[j] = allAmounts[j] + allAmounts[j - coin];
                }
            }
        }

        return allAmounts[allAmounts.length-1];
    }

    public int coinChange(int[] coins, int amount) {
        int[] allAmounts = new int[amount+1];
        Arrays.fill(allAmounts, Integer.MAX_VALUE);
        allAmounts[0] = 0;

        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (coin <= j && allAmounts[j - coin]!= Integer.MAX_VALUE) {
                    allAmounts[j] = Math.min(allAmounts[j],  1+ allAmounts[j - coin]);
                }
            }
        }

        int minAmounts = allAmounts[allAmounts.length-1];;
        return (minAmounts == Integer.MAX_VALUE) ? -1 : minAmounts;

    }

}
