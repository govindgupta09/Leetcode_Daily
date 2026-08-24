class Solution {

    int[] dp;

    int solve(int i, int[] preSum) {

        int n = preSum.length;

        if (i == n - 1) {
            return preSum[n - 1];
        }

        if (dp[i] != Integer.MIN_VALUE) {
            return dp[i];
        }

        int take = preSum[i] - solve(i + 1, preSum);
        int skip = solve(i + 1, preSum);

        return dp[i] = Math.max(take, skip);
    }

    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        int[] preSum = new int[n];

        preSum[0] = stones[0];

        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + stones[i];
        }

        dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        return solve(1, preSum);
    }
}