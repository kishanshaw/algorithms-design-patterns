package algorithms.dynamicprogramming;

public class EditDistanceProblem {

    public int editDistanceUsingTabulation(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int row = 0; row <= m; row++) {
            dp[row][0] = row;
        }
        for (int col = 0; col <= n; col++) {
            dp[0][col] = col;
        }
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = 1 + min(dp[row - 1][col], dp[row][col - 1], dp[row - 1][col - 1]);
                }
            }
        }
        return dp[m][n];
    }

    private int min(int... num) {
        int min = Integer.MAX_VALUE;
        for (int a : num) {
            min = Math.min(a, min);
        }
        return min;
    }
}
