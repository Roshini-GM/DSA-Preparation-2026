import java.util.*;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(0, s.toCharArray(), ans);
        return ans;
    }

    void backtrack(int index, char[] s, List<String> ans) {
        if (index == s.length) {
            ans.add(new String(s));
            return;
        }

        if (Character.isLetter(s[index])) {
            s[index] = Character.toLowerCase(s[index]);
            backtrack(index + 1, s, ans);

            s[index] = Character.toUpperCase(s[index]);
            backtrack(index + 1, s, ans);
        } else {
            backtrack(index + 1, s, ans);
        }
    }
}