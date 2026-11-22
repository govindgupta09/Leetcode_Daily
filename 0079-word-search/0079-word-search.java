class Solution {

    public boolean solve(char[][] board, int row, int col, String word, int index) {

        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Character doesn't match or cell already visited
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // All characters matched
        if (index == word.length() - 1) {
            return true;
        }

        char ch = board[row][col];

        // Mark visited
        board[row][col] = '0';

        // Explore all 4 directions
        boolean found =
                solve(board, row - 1, col, word, index + 1) ||
                solve(board, row + 1, col, word, index + 1) ||
                solve(board, row, col - 1, word, index + 1) ||
                solve(board, row, col + 1, word, index + 1);

        // Backtrack: restore original character
        board[row][col] = ch;

        return found;
    }

    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if (solve(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}