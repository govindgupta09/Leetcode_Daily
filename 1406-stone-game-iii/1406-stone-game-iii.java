class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int l = stoneValue.length;

        // value[i] = {current player's score, opponent's score}
        int[][] value = new int[l + 1][2];

        for (int i = l - 1; i >= 0; i--) {
            int sum = 0;

            // Player can take 1, 2, or 3 stones
            for (int j = 1; j <= 3 && i + j <= l; j++) {
                sum += stoneValue[i + j - 1];

                // After taking j stones, roles are swapped
                int currentScore = sum + value[l - i - j][1];
                int opponentScore = value[l - i - j][0];

                // Choose the move that maximizes current player's score
                if (j == 1 || currentScore > value[l - i][0]) {
                    value[l - i][0] = currentScore;
                    value[l - i][1] = opponentScore;
                }
            }
        }

        if (value[l][0] > value[l][1]) {
            return "Alice";
        }

        if (value[l][0] < value[l][1]) {
            return "Bob";
        }

        return "Tie";
    }
}