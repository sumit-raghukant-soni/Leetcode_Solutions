class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        int sz = nums.size();
        if(sz <= 1) return false;
        int sum = 0;
        unordered_map<int, int> mp;
        mp[0] = -1;

        for(int i=0; i<sz; i++){
            sum += nums[i];

            if(mp.find(sum%k) == mp.end()){
                mp[sum%k] = i;
            }
            else if( i - mp[sum%k] > 1) return true;
        }

        return false;
    }
};