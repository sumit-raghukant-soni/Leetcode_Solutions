class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int, vector<int>> mp;
        int sz = nums.size();

        for(int i=0; i<sz; i++){
            mp[nums[i]].push_back(i);
        }

        for(auto i : mp){
            int tmp = INT_MAX;
            for(int j : i.second){
                if(tmp == INT_MAX) tmp = j;
                else{
                    if(j - tmp <= k) return true;
                    tmp = j;
                }
            }
        }

        return false;
    }
};