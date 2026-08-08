class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        /*
         * nextMatch[j] = the position in word1 where word2[j]
         * can be matched while matching word2[j...m-1]
         * from right to left.
         *
         * If impossible, value = -1.
         */
        int[] nextMatch = new int[m];

        int p = n - 1;

        for (int j = m - 1; j >= 0; j--) {
            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) {
                p--;
            }

            if (p < 0) {
                nextMatch[j] = -1;
            } else {
                nextMatch[j] = p;
                p--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        int j = 0;
        boolean usedMismatch = false;

        while (i < n && j < m) {

            // Exact match -> always prefer it because i is smallest.
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                i++;
                j++;
                continue;
            }

            // Try using the one allowed mismatch.
            if (!usedMismatch) {

                boolean canFinish = false;

                // If this is the last character, mismatch is enough.
                if (j == m - 1) {
                    canFinish = true;
                }
                // Otherwise, the remaining suffix must be matched
                // exactly using indices strictly greater than i.
                else if (nextMatch[j + 1] > i) {
                    canFinish = true;
                }

                if (canFinish) {
                    ans[j] = i;
                    usedMismatch = true;
                    i++;
                    j++;
                    continue;
                }
            }

            // Cannot use i, move forward.
            i++;
        }

        return j == m ? ans : new int[0];
    }
}