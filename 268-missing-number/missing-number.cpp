class Solution {
public:
    int missingNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        int sz = nums.size();
        for(int i=0; i<sz; i++){
            if(i != nums[i]) return i;
        }

        return sz;
    }
};