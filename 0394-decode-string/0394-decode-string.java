import java.util.*;
class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();
        String cur = "";
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } 
            else if (c == '[') {
                nums.push(num);
                strs.push(cur);
                num = 0;
                cur = "";
            } 
            else if (c == ']') {
                int k = nums.pop();
                String prev = strs.pop();
                cur = prev + cur.repeat(k);
            } 
            else {
                cur += c;
            }
        }
        return cur;
    }
}