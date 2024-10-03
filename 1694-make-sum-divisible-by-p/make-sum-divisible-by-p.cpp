class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        int sz = nums.size(), rem = 0, ans = sz;
        long sum = 0, cSum = 0, cMod = 0, rMod = 0;
        unordered_map<int, int> mp;
        mp[0] = -1;

        for(int i : nums) sum += i;

        rem = sum%p;
        if(rem == 0) return 0;

        for(int i=0; i<sz; i++){
            cSum += nums[i];
            cMod = cSum%p;
            rMod = (cMod - rem + p) % p;
            if(mp.find(rMod) != mp.end()){
                ans = min(ans, i-mp[rMod]);
            }
            mp[cMod] = i;
        }

        return ans == sz ? -1 : ans;
    }
};