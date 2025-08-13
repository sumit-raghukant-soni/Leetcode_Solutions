class Solution {
    long dp[][] = null, MOD = 1000000007;
    int used[] = null;
    public int numberOfWays(int n, int x) {
        dp = new long[n+1][n+1];
        used = new int[n+1];

        for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1L);
        solve(n, x, 1);

        return (int) dp[n][1];
    }

    private long solve(int i, int x, int j){
        if(i == 0) return 1;
        if(i < 0 || j > i) return 0;
        if(dp[i][j] != -1L) return dp[i][j];

        long cnt = 0, tmp = (long) Math.pow(j, x);
        if(tmp <= i){
            cnt += solve(i - (int) tmp, x, j+1);
        }

        cnt += solve(i, x, j+1);

        return dp[i][j] = cnt%MOD;
    }
}