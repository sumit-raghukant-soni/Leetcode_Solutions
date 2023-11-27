class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int sz = nums.size();
        vector<int> suf(sz, 0), pref(sz, 0);

        pref[0] = nums[0];
        for(int i=1; i<sz; i++) pref[i] = nums[i] + pref[i-1];
        suf[sz-1] = nums[sz-1];
        for(int i=sz-2; i>=0; i--) suf[i] = nums[i] + suf[i+1]; 

        for(int i=0; i<sz; i++){
            int prev = 0, next = 0;
            if(i-1 >= 0) prev = pref[i-1];
            if(i+1 < sz) next = suf[i+1];
            if(prev == next) return i;
        }

        return -1;
    }
};