class Solution {
public:
    int rob(vector<int>& nums) {
        int sz = nums.size();
        vector<int> dp(sz+1);

        dp[0] = 0;
        dp[1] = nums[0];
        if(sz > 1) dp[2] = nums[1];
        for(int i=3; i<=sz; i++){
            dp[i] = max(dp[i-2], dp[i-3]) + nums[i-1];
        }

        return dp[sz] > dp[sz-1] ? dp[sz] : dp[sz-1];
    }
};