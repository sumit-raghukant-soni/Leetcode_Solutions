class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int sz = nums.size();
        long long pro = 1;
        int cnt = 0;
        vector<int> ans(sz, 0);

        for(int i=0; i<sz; i++){
            if(nums[i] != 0) pro *= nums[i];
            if(nums[i] == 0) cnt++;
        }

        for(int i=0; i<sz; i++){
            if(cnt == 0 || (nums[i] == 0 && cnt == 1)){
                if(nums[i] != 0) ans[i] = pro/nums[i];
                else ans[i] = pro;
            }
        }

        return ans;
    }
};