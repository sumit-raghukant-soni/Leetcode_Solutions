class Solution {
public:
    int minPairSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int sz = nums.size(), ans = 0;
        for(int i=0; i<sz/2; i++){
            ans = max(ans, nums[i] + nums[sz-1-i]);
        }
        return ans;
    }
};