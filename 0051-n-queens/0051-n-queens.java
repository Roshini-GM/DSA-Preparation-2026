import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        solve(0, n, board, ans);
        return ans;
    }

    void solve(int row, int n, char[][] board, List<List<String>> ans) {
        if (row == n) {
            List<String> temp = new ArrayList<>();

            for (char[] r : board)
                temp.add(new String(r));

            ans.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, n, board)) {
                board[row][col] = 'Q';

                solve(row + 1, n, board, ans);

                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(int row, int col, int n, char[][] board) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }
}