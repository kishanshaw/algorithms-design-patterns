package algorithms.dynamicprogramming;

import java.util.Arrays;

public class MinimumJumps {

    public int getMinJumps(int[] jumps) {
        int n = jumps.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + jumps[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[n - 1];
    }

}
