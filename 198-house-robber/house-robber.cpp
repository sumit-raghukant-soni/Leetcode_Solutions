class Solution {
public:
    int rob(vector<int>& nums) {
        int sz = nums.size();
        if(sz == 1) return nums[0];
        if(sz == 2) return max(nums[0], nums[1]);
        vector<int> dp(sz+1);
        int a, b;

        for(int i=0; i<sz+1; i++){
            if(i < sz) dp[i] = nums[i];
            a = i-2 >= 0 ? dp[i-2] : 0, b = i-3 >= 0 ? dp[i-3] : 0;
            dp[i] += max(a, b);
        }

        return max(dp[sz], dp[sz-1]);
    }
};