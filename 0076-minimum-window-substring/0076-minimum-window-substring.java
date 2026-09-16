class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int left = 0, right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (count[c] > 0) {
                required--;
            }
            count[c]--;
            right++;
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                char x = s.charAt(left);
                count[x]++;
                if (count[x] > 0) {
                    required++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
