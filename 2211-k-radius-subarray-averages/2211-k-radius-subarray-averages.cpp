class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        if(k == 0) return nums;
        vector<int> ans(nums.size(), -1);
        long long sum = 0;
        for(int i=0; i<nums.size(); i++){
            sum += nums[i];
            if(i >= k*2){
                ans[i - k] = sum/(k*2+1);
                sum -= nums[i - k*2];
            }
        }
        return ans;
    }
};