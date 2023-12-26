class Solution {
public:
    int MOD = 1000000007;
    int solve(vector<vector<int>>& dp, int n, int target, int k){
        if(n == 0 && target == 0) return 1;
        if(n <= 0 || target <= 0) return 0;

        if(dp[n][target] != -1) return dp[n][target] % MOD;

        int ways = 0;
        for(int i=1; i<=k; i++){
            ways = (ways + solve(dp, n-1, target - i, k)) % MOD;
        }
        return dp[n][target] = ways;
    }
    int numRollsToTarget(int n, int k, int target) {
        vector<vector<int>> dp(n+1, vector<int>(target+1, -1));

        solve(dp, n, target, k);

        return dp[n][target];
    }
};