class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int sz = nums.size();
        vector<int> ans(sz, 0), pre(sz, 0), suf(sz, 0);
        for(int i=0; i<sz; i++){
            if(i-1>=0){
                pre[i] = nums[i] * pre[i-1];
            }
            else pre[i] = nums[i];
        }

        for(int i=sz-1; i>=0; i--){
            if(i+1<sz){
                suf[i] = nums[i] * suf[i+1];
            }
            else suf[i] = nums[i];
        }

        for(int i=0; i<sz; i++){
            ans[i] = (i-1 >= 0 ? pre[i-1] : 1) * (i+1 < sz ? suf[i+1] : 1);
        }

        return ans;
    }
};