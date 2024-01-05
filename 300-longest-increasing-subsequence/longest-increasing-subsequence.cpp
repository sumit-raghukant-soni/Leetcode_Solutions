class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int ans = 0, sz = nums.size();
        vector<int> dp(sz);
        for(int i=0; i<nums.size(); i++){
            int j=i, tmp = 0;
            while(j>=0){
                if(nums[j] < nums[i]) tmp = max(tmp, dp[j]);
                j--;
            }
            dp[i] = tmp+1;
        }
        for(auto i : dp) ans = max(ans, i);
        return ans;
    }
};