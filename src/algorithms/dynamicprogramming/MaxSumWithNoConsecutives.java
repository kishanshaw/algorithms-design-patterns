package algorithms.dynamicprogramming;

public class MaxSumWithNoConsecutives {

    public int getMax(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[1] = arr[0];
        dp[2] = Math.max(arr[0], arr[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], arr[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }

}
