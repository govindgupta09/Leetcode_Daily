class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[j] = number of ways to form t[0...j-1]
        // using characters processed so far from s
        long[] dp = new long[n + 1];

        // Empty string can always be formed in exactly 1 way
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            // Traverse backwards so that dp[j - 1]
            // still represents the previous row
            for (int j = Math.min(i, n); j >= 1; j--) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return (int) dp[n];
    }
}