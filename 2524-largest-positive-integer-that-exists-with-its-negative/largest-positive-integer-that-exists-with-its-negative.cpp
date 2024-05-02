class Solution {
public:
    int findMaxK(vector<int>& nums) {
        int sz = nums.size(), ans = -1;
        unordered_map<int, int> mp;

        for(int i=0; i<sz;i++){
            if(mp.find(nums[i] * -1) != mp.end()) ans = max(ans, abs(nums[i]));
            mp[nums[i]]++;
        }

        return ans;
    }
};