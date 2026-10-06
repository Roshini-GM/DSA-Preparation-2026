class Solution {
    public int[] beautifulArray(int n) {
        if (n == 1)
            return new int[]{1};
        int[] odd = beautifulArray((n + 1) / 2);
        int[] even = beautifulArray(n / 2);
        int[] ans = new int[n];
        int k = 0;
        for (int x : odd)
            ans[k++] = 2 * x - 1;
        for (int x : even)
            ans[k++] = 2 * x;
        return ans;
    }
}