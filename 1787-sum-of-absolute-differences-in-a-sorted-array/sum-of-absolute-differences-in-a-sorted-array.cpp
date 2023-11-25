class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        long long sum = 0;
        int sz = nums.size();
        vector<int> ans(sz, 0);
        vector<int> pref(sz, 0), suf(sz, 0);

        for(int i=0; i<sz; i++){
            if(i == 0) pref[i] = nums[i];
            else pref[i] = pref[i-1] + nums[i];

            if(i == 0) suf[sz-1] = nums[sz-1];
            else suf[sz-1-i] = nums[sz-1-i] + suf[sz-i];
        }

        for(int i=0; i<sz; i++){
            if(i-1 >= 0){
                ans[i] += (nums[i]*i) - pref[i-1];
            }
            if(i+1 < sz){
                ans[i] += suf[i+1] - (nums[i]*(sz - (i+1)));
            }
        }

        return ans;
    }
};