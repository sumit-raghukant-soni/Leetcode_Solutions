class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int ind = 0, sz = nums.size();

        for(int i=0; i<sz; i++){
            nums[ind++] = nums[i];
            while(i+1 < sz && nums[i] == nums[i+1]) i++;
        }

        return ind;
    }
};