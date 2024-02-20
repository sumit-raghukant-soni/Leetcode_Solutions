class Solution {
public:
    int missingNumber(vector<int>& nums) {

        int sz = nums.size(), total = (sz * (sz+1)) / 2;
        for(int i=0; i<sz; i++){
            total -= nums[i];
        }

        return total;
    }
};