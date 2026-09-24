class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        int maxx = 0;
        int freq = 0;
        for (char task : tasks) {
            int idx = (int) task - 65;
            taskCount[idx]++;
            if (taskCount[idx] > maxx)
                maxx = taskCount[idx];
        }
        for (int count : taskCount)
            if (count == maxx)
                freq++;
        return Math.max((n + 1) * (maxx - 1) + freq, tasks.length);
    }
}