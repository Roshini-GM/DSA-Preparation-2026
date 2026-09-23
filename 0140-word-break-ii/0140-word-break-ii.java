import java.util.*;
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return solve(s, 0, set, memo);
    }
    List<String> solve(String s, int start, Set<String> set,
                       Map<Integer, List<String>> memo) {
        if (start == s.length())
            return Arrays.asList("");
        if (memo.containsKey(start))
            return memo.get(start);
        List<String> result = new ArrayList<>();
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (set.contains(word)) {
                List<String> rest = solve(s, end, set, memo);
                for (String r : rest) {
                    if (r.isEmpty())
                        result.add(word);
                    else
                        result.add(word + " " + r);
                }
            }
        }
        memo.put(start, result);
        return result;
    }
}