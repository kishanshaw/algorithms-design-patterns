package algorithms.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    private int[][] dp;
    private String s1, s2;

    public LongestCommonSubsequence(String s1, String s2, int m, int n) {
        dp = new int[m + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
    }

    public int lcsUsingMemoization(String s1, String s2, int m, int n) {
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (m == 0 || n == 0) {
            dp[m][n] = 0;
        } else {
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                dp[m][n] = 1 + lcsUsingMemoization(s1, s2, m - 1, n - 1);
            } else {
                dp[m][n] = Math.max(lcsUsingMemoization(s1, s2, m - 1, n), lcsUsingMemoization(s1, s2, m, n - 1));
            }
        }
        return dp[m][n];
    }

    public int lcsUsingTabulation(String s1, String s2, int m, int n) {
        dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[j][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
