class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        unordered_map<int, int> mp;
        
        for(int i : nums) mp[i]++;

        int sz = nums.size(), repeated = 0, missing = 0;

        for(int i=1; i<=sz; i++){
            if(mp[i] > 1) repeated = i;
            if(mp[i] < 1) missing = i;
            if(repeated != 0 && missing != 0) break;
        }

        return {repeated, missing};
    }
};