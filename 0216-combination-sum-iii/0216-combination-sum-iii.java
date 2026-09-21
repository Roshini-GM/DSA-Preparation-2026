import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int start, int k, int n, List<Integer> temp,
                   List<List<Integer>> ans) {

        if (temp.size() == k) {
            if (n == 0)
                ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > n)
                break;

            temp.add(i);

            backtrack(i + 1, k, n - i, temp, ans);

            temp.remove(temp.size() - 1);
        }
    }
}