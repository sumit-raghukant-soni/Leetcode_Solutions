class Solution {
public:
    long long minOperationsToMakeMedianK(vector<int>& nums, int k) {
        long long ans = 0;
        int sz = nums.size();
        sort(nums.begin(), nums.end());
        int mid = sz/2;
        ans += abs(nums[mid] - k);
        nums[mid] = k;
        
        for(int i=0; i<sz; i++){
            if((i < mid && nums[mid] < nums[i]) || (i > mid && nums[mid] > nums[i])){
                ans += abs(nums[i] - k);
            }
        }
        
        return ans;
    }
};