import java.util.*;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            boolean destroyed = false;
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                if (stack.peek() < -a) {
                    stack.pop();
                } 
                else if (stack.peek() == -a) {
                    stack.pop();
                    destroyed = true;
                    break;
                } 
                else {
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) {
                stack.push(a);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.get(i);
        }
        return ans;
    }
}