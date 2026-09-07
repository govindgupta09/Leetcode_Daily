class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;

        // last[c] = number of distinct subsequences
        // before the previous occurrence of character c
        long[] last = new long[26];

        long total = 0;

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';

            // Every existing subsequence can append ch,
            // and ch itself forms a new subsequence.
            long newSubseq = (total + 1) % MOD;

            // Remove duplicates created by previous occurrence of ch.
            total = (total + newSubseq - last[c] + MOD) % MOD;

            // Remember the contribution created by this occurrence.
            last[c] = newSubseq;
        }

        return (int) total;
    }
}