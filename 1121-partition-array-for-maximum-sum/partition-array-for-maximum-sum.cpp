class Solution {
public:
    int solve(vector<vector<int>>& dp, vector<int>& arr, int ind, int& sz, int k){
        if(ind == sz) return 0;
        
        if(dp[ind][k] != -1) return dp[ind][k];
        
        int tmp = INT_MIN, maxSum = INT_MIN, ans = INT_MIN;
        for(int i=ind; i<sz && i <= ind+k; i++){
            tmp = max(tmp, arr[i]);
            maxSum = max(maxSum, (tmp * (i - ind + 1)));
            ans = max(ans, solve(dp, arr, i+1, sz, k) + maxSum);
        }
        return dp[ind][k] = ans;
    }
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int ans = 0, sz = arr.size();
        vector<vector<int>> dp(sz, vector<int>(k, -1));

        ans = solve(dp, arr, 0, sz, k-1);

        return ans;
    }
};