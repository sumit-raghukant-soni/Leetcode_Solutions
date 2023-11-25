class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int i=0,j;
        int sz = nums.size();

        while(i < sz){
            while(i<sz && nums[i] != 0) i++;
            j = i;
            while(j<sz && nums[j] == 0) j++;

            if(i<sz && j<sz) swap(nums[i], nums[j]);
            i++;
        }
    }
};