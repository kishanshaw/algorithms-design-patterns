package algorithms.dynamicprogramming;

import java.util.Arrays;

public class MinimumCoinsForValue {

    public int getMin(int[] coins, int val) {
        int n = coins.length;
        int[] dp = new int[val + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= val; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[val];
    }
}