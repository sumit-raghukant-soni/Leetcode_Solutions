class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int sz = nums.size();
        unordered_map<int, int> mp;

        for(int i = sz-1; i >= 0; i--){
            if(nums[i] <= k) mp[nums[i]]++;
            if(mp.size() == k) return sz - i;
        }
        
        return sz;
    }
};