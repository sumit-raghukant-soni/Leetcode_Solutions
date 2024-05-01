class Solution {
public:
    int solve(vector<int>& dp, vector<int>& coins, int sz, int amount){
        if(amount == 0) return 0;

        if(dp[amount] != -1) return dp[amount];

        int take = 1e8;
        for(int i=0; i<sz; i++){
            if(amount >= coins[i]) take = min(take, 1 + solve(dp, coins, sz, amount-coins[i]));
        }
        // cout << amount << " " << take;
        return dp[amount] = take;
    }
    int coinChange(vector<int>& coins, int amount) {
        if(amount == 0) return 0;

        int sz = coins.size();
        vector<int> dp(amount+1, -1);

        solve(dp, coins, sz, amount);

        return dp[amount] == 1e8 ? -1 : dp[amount];
    }
};