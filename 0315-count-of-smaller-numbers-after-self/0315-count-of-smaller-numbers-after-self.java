class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;

        for (int x : sorted) {
            if (!rank.containsKey(x)) {
                rank.put(x, r++);
            }
        }

        int[] bit = new int[r + 1];
        Integer[] ans = new Integer[n];

        for (int i = n - 1; i >= 0; i--) {
            int pos = rank.get(nums[i]);
            ans[i] = query(bit, pos - 1);
            update(bit, pos);
        }

        return Arrays.asList(ans);
    }

    private void update(int[] bit, int i) {
        while (i < bit.length) {
            bit[i]++;
            i += i & -i;
        }
    }

    private int query(int[] bit, int i) {
        int sum = 0;

        while (i > 0) {
            sum += bit[i];
            i -= i & -i;
        }

        return sum;
    }
}