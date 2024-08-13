class Solution {
public:
    int solve(vector<int>& nums, int s, int e){
        vector<int> dp(e+1, 0);

        for(int i=s; i<=e; i++){
            int v1 = 0, v2 = 0;
            if(i-1 >= s) v1 = dp[i-1];
            if(i-2 >= s) v2 = dp[i-2];
            dp[i] = max(v1, v2 + nums[i]);
        }

        // for(int i : dp) cout << i << " ";
        // cout << endl;

        return dp[e];
    }
    int rob(vector<int>& nums) {
        int sz = nums.size();
        if(sz == 1) return nums[0];
        if(sz == 2) return max(nums[0], nums[1]);
        return max(solve(nums, 0, sz-2), solve(nums, 1, sz-1));
    }
};