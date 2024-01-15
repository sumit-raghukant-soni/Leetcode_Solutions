class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int sz = nums.size();
        vector<int> ans(sz, 0);

        int val = 1;
        for(int i=0; i<sz; i++){
            ans[i] = val;
            val = nums[i] * val;
        }
        val = 1;
        for(int i=sz-1; i>=0; i--){
            ans[i] *= val;
            val = nums[i] * val;
        }

        return ans;
    }
};