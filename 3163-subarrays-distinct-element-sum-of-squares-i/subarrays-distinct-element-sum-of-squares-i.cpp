class Solution {
public:
    int sumCounts(vector<int>& nums) {
        unordered_map<int, int> mp;
        int sz = nums.size();
        int ans = 0;
        for(int i=0; i<sz; i++){
            mp.clear();
            for(int j=i; j<sz; j++){
                mp[nums[j]]++;
                ans += mp.size() * mp.size();
            }
        }

        return ans;
    }
};