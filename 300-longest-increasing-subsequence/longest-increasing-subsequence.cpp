class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int sz = nums.size(), ans = 0;
        vector<int> dp(sz, 0);

        for(int i=0; i<sz; i++){
            int j = i, tmp = 0;
            while(j >= 0){
                if(nums[j] < nums[i]) tmp = max(tmp, dp[j]);
                j--;
            }
            dp[i] = tmp + 1;
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};