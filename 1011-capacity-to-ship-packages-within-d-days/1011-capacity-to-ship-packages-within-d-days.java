class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int current = 0;
            int requiredDays = 1;
            for (int w : weights) {
                if (current + w > mid) {
                    requiredDays++;
                    current = 0;
                }
                current += w;
            }
            if (requiredDays <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}