import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, 0, "", ans);
        return ans;
    }

    void backtrack(String s, int index, int parts, String ip,
                   List<String> ans) {

        if (parts == 4) {
            if (index == s.length())
                ans.add(ip.substring(0, ip.length() - 1));
            return;
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);

            if (part.length() > 1 && part.charAt(0) == '0')
                break;

            if (Integer.parseInt(part) > 255)
                break;

            backtrack(s, index + len, parts + 1,
                      ip + part + ".", ans);
        }
    }
}