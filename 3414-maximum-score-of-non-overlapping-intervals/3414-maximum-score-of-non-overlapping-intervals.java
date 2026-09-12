import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        // [left, right, weight, originalIndex]
        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        // Sort by starting point
        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0]) {
                return Integer.compare(x[0], y[0]);
            }
            if (x[1] != y[1]) {
                return Integer.compare(x[1], y[1]);
            }
            return Integer.compare(x[3], y[3]);
        });

        // next[i] = first interval whose left > a[i].right
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = findNext(a, i);
        }

        /*
         * dpScore[i][k]:
         * Maximum score we can get from i onward
         * using at most k intervals.
         */
        long[][] dpScore = new long[n + 1][5];

        /*
         * dpAns[i][k]:
         * Lexicographically smallest set of indices
         * achieving dpScore[i][k].
         */
        int[][][] dpAns = new int[n + 1][5][];

        // At the end, choosing nothing is valid.
        for (int k = 0; k <= 4; k++) {
            dpAns[n][k] = new int[0];
        }

        // If we are allowed to choose 0 intervals,
        // the answer is always empty.
        for (int i = 0; i <= n; i++) {
            dpAns[i][0] = new int[0];
        }

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // ---------------------------------
                // Option 1: Skip interval i
                // ---------------------------------
                long skipScore = dpScore[i + 1][k];
                int[] skipAns = dpAns[i + 1][k];

                // ---------------------------------
                // Option 2: Take interval i
                // ---------------------------------
                long takeScore =
                        a[i][2] + dpScore[next[i]][k - 1];

                int[] takeAns = addIndex(
                        a[i][3],
                        dpAns[next[i]][k - 1]
                );

                // ---------------------------------
                // Choose the better option
                // ---------------------------------
                if (takeScore > skipScore) {

                    dpScore[i][k] = takeScore;
                    dpAns[i][k] = takeAns;

                } else if (takeScore < skipScore) {

                    dpScore[i][k] = skipScore;
                    dpAns[i][k] = skipAns;

                } else {

                    // Same score:
                    // choose lexicographically smaller indices.
                    dpScore[i][k] = skipScore;

                    if (compareLex(takeAns, skipAns) < 0) {
                        dpAns[i][k] = takeAns;
                    } else {
                        dpAns[i][k] = skipAns;
                    }
                }
            }
        }

        return dpAns[0][4];
    }

    /*
     * Find the first interval j such that:
     *
     * a[j].left > a[i].right
     *
     * Strict > is important because intervals sharing
     * an endpoint are considered overlapping.
     */
    private int findNext(int[][] a, int i) {

        int target = a[i][1];

        int left = i + 1;
        int right = a.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (a[mid][0] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /*
     * Add an original index to the selected indices
     * and keep them sorted.
     */
    private int[] addIndex(int index, int[] old) {

        int[] result = new int[old.length + 1];

        int pos = 0;

        // Insert index in sorted position
        while (pos < old.length && old[pos] < index) {
            result[pos] = old[pos];
            pos++;
        }

        result[pos] = index;

        // Copy remaining elements
        while (pos < old.length) {
            result[pos + 1] = old[pos];
            pos++;
        }

        return result;
    }

    /*
     * Compare two arrays lexicographically.
     *
     * Returns:
     *   < 0  -> a is smaller
     *   = 0  -> equal
     *   > 0  -> a is larger
     */
    private int compareLex(int[] a, int[] b) {

        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {

            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }

        return Integer.compare(a.length, b.length);
    }
}