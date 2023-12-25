class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int sz = nums.size();
        vector<int> ans(sz, 0);
        int even = 0, odd = 1;
        for(int i=0; i<sz; i++){
            if(nums[i] > 0){
                ans[even] = nums[i];
                even+=2;
            }
            else{
                ans[odd] = nums[i];
                odd+=2;
            }
        }

        return ans;
    }
};