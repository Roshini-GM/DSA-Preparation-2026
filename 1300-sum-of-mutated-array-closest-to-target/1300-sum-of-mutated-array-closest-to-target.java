class Solution {
    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 0;
        for (int num : arr) {
            right = Math.max(right, num);
        }
        int best = right;
        int bestDiff = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int num : arr) {
                sum += Math.min(num, mid);
            }
            int diff = Math.abs(sum - target);
            if (diff < bestDiff || 
                (diff == bestDiff && mid < best)) {
                bestDiff = diff;
                best = mid;
            }
            if (sum < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return best;
    }
}