class Solution {
public:
    bool solve(vector<vector<int>>& dp, vector<int>& nums, int sz, int target, int currSum, int ind){
        if(target == currSum) return true;
        if(ind == sz) return false;

        if(dp[ind][currSum] != -1) return dp[ind][currSum];

        bool take = false, notTake = solve(dp, nums, sz, target, currSum, ind+1);
        if(nums[ind] + currSum <= target){
            take = solve(dp, nums, sz, target, currSum + nums[ind], ind+1);
        }
        return dp[ind][currSum] = take || notTake;
    }
    bool canPartition(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0), sz = nums.size();
        vector<vector<int>> dp(sz, vector<int>(sum, -1));
        
        if(sum&1) return false;
        return solve(dp, nums, sz, sum/2, 0, 0);
    }
};