class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int i=0;
        while(i<=nums.size()-1 && nums[i] < target)
        {
            if(nums[i] >= target)
                break;
            i++;
        }
        return i;
    }
};