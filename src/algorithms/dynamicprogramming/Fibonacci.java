package algorithms.dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {
    private int[] memo;

    public Fibonacci(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
    }

    public int fibUsingMemoization(int n) {
        if (memo[n] == -1) {
            int res;
            if (n == 0 || n == 1) {
                res = n;
            } else {
                res = fibUsingMemoization(n - 1) + fibUsingMemoization(n - 2);
            }
            memo[n] = res;
        }
        return memo[n];
    }

    public int fibUsingTabulation(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
