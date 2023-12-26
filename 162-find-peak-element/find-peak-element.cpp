class Solution {
public:
    int BS(vector<int>& nums, int& sz, int s, int e){
        if(s > e) return 0;

        int mid = s + (e-s)/2;

        int prev = mid-1 >= 0 ? nums[mid-1] : INT_MIN;
        int next = mid+1 < sz ? nums[mid+1] : INT_MIN;

        if(prev < nums[mid] && next < nums[mid]) return mid;

        int left = BS(nums, sz, s, mid-1);
        int right = BS(nums, sz, mid+1, e);

        return left ? left : right;
    }
    int findPeakElement(vector<int>& nums) {
        int sz = nums.size();
        return BS(nums, sz, 0, sz-1);
    }
};