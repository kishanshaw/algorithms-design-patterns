package algorithms.dynamicprogramming;

public class UniqueBSTs {

    public int getUniqueBSTs(int keys) {
        int[] dp = new int[keys + 1];
        dp[0] = 1;
        for (int i = 1; i <= keys; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[keys];
    }
}