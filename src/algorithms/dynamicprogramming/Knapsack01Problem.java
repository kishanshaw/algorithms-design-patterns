package algorithms.dynamicprogramming;

public class Knapsack01Problem {

    public int getValueRecursive(int[] weights, int[] profits, int capacity, int n) {
        if (n == 0 || capacity == 0) {
            return 0;
        }
        if (weights[n - 1] > capacity) {
            return getValueRecursive(weights, profits, capacity, n - 1);
        } else {
            return Math.max(getValueRecursive(weights, profits, capacity, n - 1),
                    profits[n - 1] + getValueRecursive(weights, profits, capacity - weights[n - 1], n - 1));
        }
    }

    public int getValue(int capacity, int[] weight, int[] profits) {
        int n = profits.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int w = 0; w <= capacity; w++) {
            dp[0][w] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] > capacity) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (j - weight[i - 1] >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], profits[i - 1] + dp[i - 1][j - weight[i - 1]]);
                    }
                }
            }
        }
        return dp[n][capacity];
    }
}