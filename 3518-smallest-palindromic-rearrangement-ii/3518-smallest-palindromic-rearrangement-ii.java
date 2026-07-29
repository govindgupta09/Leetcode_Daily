class Solution {

    private static final int LIMIT = 1_000_000;

    public String smallestPalindrome(String s, int k) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] half = new int[26];
        int halfLength = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLength += half[i];

            if ((freq[i] & 1) == 1) {
                middle = (char) ('a' + i);
            }
        }

        // Check if at least k permutations exist
        if (countWays(half, halfLength, k) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLength; pos++) {

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0) {
                    continue;
                }

                // Choose c
                half[c]--;

                long ways = countWays(
                    half,
                    halfLength - pos - 1,
                    k
                );

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                }

                // Skip this block
                k -= ways;

                // Undo choice
                half[c]++;
            }
        }

        String leftPart = left.toString();
        String rightPart =
            new StringBuilder(leftPart).reverse().toString();

        if (middle != 0) {
            return leftPart + middle + rightPart;
        }

        return leftPart + rightPart;
    }

    /*
     * Count distinct permutations of the remaining multiset.
     *
     * Formula:
     *
     *      total!
     *  ----------------
     *  p1! p2! ... p26!
     *
     * We only care whether the answer reaches k.
     */
    private long countWays(
            int[] freq,
            int total,
            int k) {

        long ways = 1;

        /*
         * Build:
         *
         * C(total, freq[0])
         * C(total - freq[0], freq[1])
         * ...
         *
         * This gives:
         *
         * total! / (freq[0]! * freq[1]! * ...)
         */
        int remaining = total;

        for (int count : freq) {

            if (count == 0) {
                continue;
            }

            long combinations =
                cappedCombination(
                    remaining,
                    count,
                    k
                );

            ways *= combinations;

            if (ways >= k) {
                return k;
            }

            remaining -= count;
        }

        return ways;
    }

    /*
     * Computes C(n, r), capped at limit.
     */
    private long cappedCombination(
            int n,
            int r,
            int limit) {

        r = Math.min(r, n - r);

        long result = 1;

        for (int i = 1; i <= r; i++) {

            /*
             * result = result * (n - r + i) / i
             *
             * The final result is always integral.
             */
            result =
                result * (n - r + i) / i;

            if (result >= limit) {
                return limit;
            }
        }

        return result;
    }
}