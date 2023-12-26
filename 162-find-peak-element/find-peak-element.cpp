class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int sz = nums.size();

        for(int i=0; i<sz; i++){
            int prev = i-1 >= 0 ? nums[i-1] : INT_MIN;
            int next = i+1 < sz ? nums[i+1] : INT_MIN;
            if(nums[i] > prev && nums[i] > next) return i;
        }

        return 0;
    }
};