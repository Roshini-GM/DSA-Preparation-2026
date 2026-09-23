class Solution {
    int rows, cols;
    int maxGold = 0;
    public int getMaximumGold(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0)
                    dfs(grid, i, j, 0);
            }
        }
        return maxGold;
    }
    void dfs(int[][] grid, int r, int c, int gold) {
        if (r < 0 || r >= rows || c < 0 || c >= cols ||
            grid[r][c] == 0)
            return;
        int current = grid[r][c];
        gold += current;
        maxGold = Math.max(maxGold, gold);
        grid[r][c] = 0;
        dfs(grid, r + 1, c, gold);
        dfs(grid, r - 1, c, gold);
        dfs(grid, r, c + 1, gold);
        dfs(grid, r, c - 1, gold);
        grid[r][c] = current;
    }
}