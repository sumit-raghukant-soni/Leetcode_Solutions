class Solution {
public:
    void sortColors(vector<int>& nums) {
        int sz = nums.size();
        int j=0;
        for(int i=0; i<sz; i++){
            if(nums[i] == 0) swap(nums[i], nums[j++]);
        }
        for(int i=0; i<sz; i++){
            if(nums[i] == 1) swap(nums[i], nums[j++]);
        }
    }
};