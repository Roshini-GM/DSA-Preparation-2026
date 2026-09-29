import java.util.*;
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] heights = new int[n];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            max = Math.max(max, largestRectangle(heights));
        }
        return max;
    }
    public int largestRectangle(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int current = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && current < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}