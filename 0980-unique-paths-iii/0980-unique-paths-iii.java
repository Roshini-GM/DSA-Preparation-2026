class Solution {
    int count = 0;
    int rows, cols;
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int startR = 0, startC = 0, empty = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != -1) empty++;
                if (grid[i][j] == 1) {
                    startR = i;
                    startC = j;
                }
            }
        }
        dfs(grid, startR, startC, empty);
        return count;
    }
    void dfs(int[][] grid, int r, int c, int remaining) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == -1)
            return;
        if (grid[r][c] == 2) {
            if (remaining == 1)
                count++;
            return;
        }
        int temp = grid[r][c];
        grid[r][c] = -1;
        dfs(grid, r + 1, c, remaining - 1);
        dfs(grid, r - 1, c, remaining - 1);
        dfs(grid, r, c + 1, remaining - 1);
        dfs(grid, r, c - 1, remaining - 1);
        grid[r][c] = temp;
    }
}