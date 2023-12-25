class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int cst = 0;
        int sz = cost.size();
        vector<int> dp(sz);
        
        dp[0] = cost[0];
        for(int i=1; i<sz; i++){
            int pre1 = dp[i-1], pre2 = INT_MAX;
            if(i-2 >= 0) pre2 = dp[i-2]; 
            else pre2 = 0;
            dp[i] = min(pre1, pre2) + cost[i];
        }

        return min(dp[sz-2], dp[sz-1]);
    }
};