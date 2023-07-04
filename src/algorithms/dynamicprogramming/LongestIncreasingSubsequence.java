package algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {
    public int lisUsingTabulation(int[] arr) {
        int result = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int len : dp) {
            result = Math.max(result, len);
        }
        return result;
    }

    public int lisUsingBinarySearch(int[] arr) {
        int len = 1, n = arr.length;
        int[] tail = new int[n];
        tail[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if (tail[len - 1] < arr[i]) {
                tail[len++] = arr[i];
            } else {
                int ceilingIndex = findCeilingUsingBS(tail, 0, len - 1, arr[i]);
                tail[ceilingIndex] = arr[i];
            }
        }
        return len;
    }

    public int maxSumIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sum[i] = Math.max(sum[i], sum[j] + arr[i]);
                }
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for (int num : sum) {
            maxSum = Math.max(num, maxSum);
        }
        return maxSum;
    }

    public int maxBitonicSequenceLength(int[] arr) {
        int len = Integer.MIN_VALUE, n = arr.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        //find the longest increasing sequence
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        //find the longest decreasing sequence
        int[] lds = new int[n];
        lds[n - 1] = lis[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (arr[i] > arr[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            len = Math.max(len, lds[i] + lis[i] - 1);
        }
        return len;
    }

    public int buildingBridges(int[][] bridges) {
        int noOfBridges = 0;
        List<Pair> bridgePairList = Arrays.stream(bridges).map(arr -> new Pair(arr[0], arr[1])).sorted().collect(Collectors.toList());
        int[] arr = new int[bridgePairList.size()];
        int i = 0, n = bridgePairList.size();
        for (Pair pair : bridgePairList) {
            arr[i++] = pair.getY();
        }

        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        for (int len : lis) {
            noOfBridges = Math.max(noOfBridges, len);
        }

        return noOfBridges;
    }

    private int findCeilingUsingBS(int[] tail, int low, int high, int x) {
        while (high > low) {
            int mid = low + (high - low) / 2;
            if (tail[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    static class Pair implements Comparable<Pair> {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.getX() == pair.getX()) {
                return this.getY() - pair.getY();
            }
            return this.getX() - pair.getX();
        }
    }
}
