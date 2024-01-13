class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int, int> mp;
        int sz = nums.size();

        for(int i : nums){
            mp[i]++;
            if(mp[i] > sz/2) return i;
        }

        return -1;
    }
};