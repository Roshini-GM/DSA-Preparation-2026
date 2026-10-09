class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int j = i;
            int len = 0;
            while (j < words.length &&
                   len + words[j].length() + (j - i) <= maxWidth) {
                len += words[j].length();
                j++;
            }
            int spaces = maxWidth - len;
            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    if (k > i) line.append(" ");
                    line.append(words[k]);
                }
                while (line.length() < maxWidth)
                    line.append(" ");
            } else {
                int each = spaces / gaps;
                int extra = spaces % gaps;
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        for (int x = 0; x < each; x++)
                            line.append(" ");
                        if (extra-- > 0)
                            line.append(" ");
                    }
                }
            }
            ans.add(line.toString());
            i = j;
        }
        return ans;
    }
}