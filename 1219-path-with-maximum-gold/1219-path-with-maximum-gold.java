class Solution {
    public int maxGold = 0;
    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] != 0){
                    dfs(grid,i,j,0);
                }
            }
        }
        return maxGold;
    }

    public void dfs(int[][] grid, int row, int col, int gold){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return;
        }

        int currentGold = grid[row][col];
        gold += currentGold;

        grid[row][col] = 0;

        maxGold = Math.max(maxGold, gold);

        dfs(grid, row+1, col, gold);
        dfs(grid, row-1, col, gold);
        dfs(grid, row, col+1, gold);
        dfs(grid, row, col-1, gold);

        grid[row][col] = currentGold;
    }
}