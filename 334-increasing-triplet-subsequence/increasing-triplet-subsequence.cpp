class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int sz = nums.size();
        
        vector<int> pref(sz), suf(sz);
        pref[0] = nums[0];
        for(int i=1; i<sz; i++){
            pref[i] = min(nums[i], pref[i-1]);
        }
        suf[sz-1] = nums[sz-1];
        for(int i=sz-2; i>=0; i--){
            suf[i] = max(nums[i], suf[i+1]);
        }

        for(int i=0; i<sz; i++){
            if(pref[i] < nums[i] && suf[i] > nums[i]) return true;
        }

        return false;
    }
};