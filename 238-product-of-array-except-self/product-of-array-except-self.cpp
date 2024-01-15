class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int sz = nums.size();
        vector<int> pre(sz, 0), suf(sz, 0), ans(sz, 0);

        pre[0] = nums[0];
        suf[sz-1] = nums[sz-1];

        for(int i=1; i<sz; i++){
            pre[i] = pre[i-1] * nums[i];
            suf[sz-i-1] = suf[sz-i] * nums[sz-i-1];
        }

        for(int i=0; i<sz; i++){
            if(i == 0) ans[i] = suf[i+1];
            else if(i == sz-1) ans[i] = pre[i-1];
            else ans[i] = pre[i-1] * suf[i+1];
        }

        return ans;
    }
};