class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if(amount == 0) return 0;
        int sz = coins.size();
        vector<vector<int>> dp(sz+1, vector<int>(amount+1, 0));

        for(int i=0; i<=amount; i++) dp[0][i] = INT_MAX-1;

        for(int i=1; i<=sz; i++){
            for(int j=1; j<=amount; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }

        if(dp[sz][amount] == INT_MAX-1) return -1;
        return dp[sz][amount];
    }
};