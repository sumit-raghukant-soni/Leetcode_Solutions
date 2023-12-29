class Solution {
public:
    int MOD = 1000000007;
    int numTilings(int n) {
        if(n <= 2) return n;
        int dp[n+1];
        dp[1] = 1, dp[2] = 2;

        for(int i=3; i<=n; i++){
            long long int prev = i-3 > 0 ? dp[i-3] : 1;
            dp[i] = ((dp[i-1] * 1LL * 2) + prev) % MOD;
        }
        return dp[n];
    }
};