package algorithms.dynamicprogramming;

import java.util.Arrays;

public class EggProblem {
    private int floors;
    private int eggs;
    private int[][] dp;

    public EggProblem(int floors, int eggs) {
        this.floors = floors;
        this.eggs = eggs;
        dp = new int[floors + 1][eggs + 1];
    }

    public int getMinimumTrials() {
        for (int egg = 1; egg <= eggs; egg++) {
            dp[1][egg] = 1;
            dp[0][egg] = 0;
        }

        for (int floor = 1; floor <= floors; floor++) {
            dp[floor][1] = floor;
        }

        for (int floor = 2; floor <= floors; floor++) {
            for (int egg = 2; egg <= eggs; egg++) {
                dp[floor][egg] = Integer.MAX_VALUE;
                for (int subFloor = 1; subFloor <= floor; subFloor++) {
                    dp[subFloor][egg] = Math.min(dp[subFloor][egg],
                            1 + Math.max(dp[subFloor - 1][egg - 1], dp[floor - subFloor][egg]));
                }
            }
        }
        return dp[floors][eggs];
    }

}
