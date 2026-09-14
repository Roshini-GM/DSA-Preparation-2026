import java.util.*;
class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> posA = new ArrayList<>();
        List<Integer> posB = new ArrayList<>();
        for (int i = 0; i + a.length() <= s.length(); i++) {
            if (s.substring(i, i + a.length()).equals(a)) {
                posA.add(i);
            }
        }
        for (int i = 0; i + b.length() <= s.length(); i++) {
            if (s.substring(i, i + b.length()).equals(b)) {
                posB.add(i);
            }
        }
        for (int i : posA) {
            for (int j : posB) {
                if (Math.abs(i - j) <= k) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }
}