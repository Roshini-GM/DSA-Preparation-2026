import java.util.*;
class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }
    TrieNode root = new TrieNode();
    int rows, cols;
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words)
            insert(word);

        rows = board.length;
        cols = board[0].length;

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }

    void insert(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (cur.child[index] == null)
                cur.child[index] = new TrieNode();

            cur = cur.child[index];
        }

        cur.word = word;
    }

    void dfs(char[][] board, int r, int c,
             TrieNode node, List<String> ans) {

        if (r < 0 || c < 0 || r >= rows || c >= cols ||
            board[r][c] == '#')
            return;

        char ch = board[r][c];
        TrieNode next = node.child[ch - 'a'];

        if (next == null)
            return;

        if (next.word != null) {
            ans.add(next.word);
            next.word = null;
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, next, ans);
        dfs(board, r - 1, c, next, ans);
        dfs(board, r, c + 1, next, ans);
        dfs(board, r, c - 1, next, ans);

        board[r][c] = ch;
    }
}