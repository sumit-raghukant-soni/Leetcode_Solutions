class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int ind = 0;
        int sz = nums.size();

        for(int i=0; i<sz; i++)
            if(nums[i] != val) nums[ind++] = nums[i];

        return ind;
    }
};