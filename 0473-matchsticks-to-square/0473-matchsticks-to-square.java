import java.util.*;
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int x : matchsticks)
            sum += x;
        if (sum % 4 != 0)
            return false;
        int side = sum / 4;
        Arrays.sort(matchsticks);
        int[] sides = new int[4];
        return backtrack(matchsticks, matchsticks.length - 1, sides, side);
    }
    boolean backtrack(int[] sticks, int index, int[] sides, int target) {
        if (index < 0)
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        int stick = sticks[index];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick > target)
                continue;
            if (i > 0 && sides[i] == sides[i - 1])
                continue;
            sides[i] += stick;
            if (backtrack(sticks, index - 1, sides, target))
                return true;
            sides[i] -= stick;
        }
        return false;
    }
}