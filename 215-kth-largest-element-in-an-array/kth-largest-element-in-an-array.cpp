class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int sz = nums.size();
        nth_element(nums.begin(), nums.begin() + (sz - k), nums.end());
        return nums[sz-k];
    }
};