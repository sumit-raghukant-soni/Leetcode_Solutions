class Solution {
public:
    int solve(vector<vector<int>>& dp, vector<int>& nums, int& sz, int ind, int prevIdx){
        if(ind == sz) return 0;
        
        if(dp[ind][prevIdx+1] != -1) return dp[ind][prevIdx+1];

        int take = 0, notTake = solve(dp, nums, sz, ind+1, prevIdx);

        if(prevIdx == -1 || nums[ind] > nums[prevIdx]){
            take = 1 + solve(dp, nums, sz, ind+1, ind);
        }

        return dp[ind][prevIdx+1] = max(take, notTake);
    }
    int lengthOfLIS(vector<int>& nums) {
        int sz = nums.size();
        vector<vector<int>> dp(sz, vector<int>(sz+1, -1));
        return solve(dp, nums, sz, 0, -1);
    }
};