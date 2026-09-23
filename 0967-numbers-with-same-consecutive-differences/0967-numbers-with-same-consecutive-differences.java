import java.util.*;

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            dfs(n, k, i, result);
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++)
            ans[i] = result.get(i);

        return ans;
    }

    void dfs(int n, int k, int num, List<Integer> result) {
        if (String.valueOf(num).length() == n) {
            result.add(num);
            return;
        }

        int last = num % 10;

        if (last + k <= 9)
            dfs(n, k, num * 10 + last + k, result);

        if (k != 0 && last - k >= 0)
            dfs(n, k, num * 10 + last - k, result);
    }
}