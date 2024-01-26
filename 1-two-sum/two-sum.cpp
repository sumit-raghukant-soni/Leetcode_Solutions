class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, vector<int>> mp;
        int sz = nums.size();

        for(int i=0; i<sz; i++)
            mp[nums[i]].push_back(i);

        for(int i=0; i<sz; i++){
            if(nums[i] * 2 == target){
                if(mp[nums[i]].size() > 1) return {mp[nums[i]][0], mp[nums[i]][1]};
            }
            else if(mp.find(target - nums[i]) != mp.end()){
                return {mp[target - nums[i]][0], mp[nums[i]][0]};
            }
        }

        return {-1, -1};
    }
};