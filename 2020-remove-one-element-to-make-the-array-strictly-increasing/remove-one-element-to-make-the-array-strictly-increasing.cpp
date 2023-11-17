class Solution {
public:
    bool canBeIncreasing(vector<int>& nums) {
        int prev = -1;
        int k = 0, sz = nums.size();

        for(int i=1; i<sz; i++){
            if(nums[i] <= nums[i-1]){
                if(k != 0) return false;
                k++;
                if(i-2 >= 0 && nums[i] <= nums[i-2]) nums[i] = nums[i-1];
            }
        }

        return true;
    }
};