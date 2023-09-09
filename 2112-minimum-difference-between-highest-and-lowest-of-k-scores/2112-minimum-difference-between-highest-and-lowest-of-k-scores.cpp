class Solution {
public:
    int minimumDifference(vector<int>& nums, int k) {
        if(k == 1) return 0;
        int diff = INT_MAX;
        int sz = nums.size();
        sort(nums.begin(), nums.end());
        for(int i=0; i<sz; i++){
            if(i+k-1 < sz)
                diff = min(diff, nums[i+k-1] - nums[i]);
        }
        return diff;
    }
};