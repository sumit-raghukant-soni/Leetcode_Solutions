class Solution {
public:
    int solve(int index, int buy, int& sz, vector<int>& prices, int limit, vector<vector<vector<int>>>& dp){
        if(index == sz || limit == 0) return 0;
        
        if(dp[index][buy][limit] != -1) return dp[index][buy][limit];

        int profit;
        if(buy){
            int buyit = -prices[index] + solve(index+1, 0, sz, prices, limit, dp);
            int skipit = solve(index+1, 1, sz, prices, limit, dp);
            profit = max(skipit, buyit);
        }
        else{
            int saleit = prices[index] + solve(index+1, 1, sz, prices, limit-1, dp);
            int skipit = solve(index+1, 0, sz, prices, limit, dp);
            profit = max(skipit, saleit);
        }

        return dp[index][buy][limit] = profit;
    }
    int maxProfit(vector<int>& prices) {
        int sz = prices.size();
        vector<vector<vector<int>>> dp(sz, vector<vector<int>>(2, vector<int>(3, -1)));

        return solve(0, 1, sz, prices, 2, dp);
    }
};