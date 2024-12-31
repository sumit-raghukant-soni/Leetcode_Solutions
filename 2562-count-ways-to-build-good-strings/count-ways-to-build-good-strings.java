class Solution {
    int MOD = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        long dp[] = new long[high+zero+one];

        Arrays.fill(dp, -1);
        
        return Math.toIntExact(solve(dp, low, high, zero, one, 0)%MOD);
    }

    private long solve(long[] dp, int low, int high, int zero, int one, int sum){
        if(sum > high) return 0;
        if(dp[sum] != -1) return dp[sum];

        long a = solve(dp, low, high, zero, one, sum+zero);
        if((sum+one) >= low && (sum+one) <= high) a++;

        long b = solve(dp, low, high, zero, one, sum+one);
        if((sum+zero) >= low && (sum+zero) <= high) b++;

        return dp[sum] = (a+b)%MOD;
    }
}