class Solution {
public:
    int solve(vector<int>& nums, int& sz, int& k, vector<vector<int>>& dp, int i, int j){
        // cout << i << "::" << j << endl;
        if(i >= sz) return 0;
        if(j == k){
            int sum = 0;
            for(;i<sz; i++){
                sum += nums[i];
            }
            // cout << i << j << " end " << sum << endl;
            return dp[i][j] = sum;
        }
        if(dp[i][j] != -1) return dp[i][j];

        int maxSum = INT_MAX, currSum = 0;
        for(int t = i; t<=sz-(k-j+1); t++){
            // cout << "for " << i << " " << sz-(k-j+1) << endl;
            currSum += nums[t];
            int res = max(currSum, solve(nums, sz, k, dp, t+1, j+1));
            maxSum = min(maxSum, res);
            // cout << i << " " << j << " " << maxSum << " " << res << " " << endl;
            if(currSum > maxSum) break;
        }
        // cout << i << ":" << j << " = " << maxSum << endl;
        return dp[i][j] = maxSum;
    }
    int splitArray(vector<int>& nums, int k) {
        int sz = nums.size();
        vector<vector<int>> dp(sz+1, vector<int>(k+1, -1));

        solve(nums, sz, k, dp, 0, 1);

        // for(vector<int> i : dp){
        //     for(int j : i){
        //         cout << j << " ";
        //     }
        //     cout << endl;
        // }
        
        return solve(nums, sz, k, dp, 0, 1);
    }
};