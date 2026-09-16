class Solution {
    static final long MOD = 1000000007;
    public int numberOfSets(int n, int k) {
        int a = n + k - 1;
        int b = 2 * k;
        long[] dp = new long[b + 1];
        dp[0] = 1;
        for (int i = 1; i <= a; i++) {
            for (int j = Math.min(i, b); j >= 1; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }
        return (int) dp[b];
    }
}
