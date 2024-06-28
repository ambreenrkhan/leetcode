package leetCode.dynamic;

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

}
