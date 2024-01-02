class Solution {
public:
    vector<vector<int>> findMatrix(vector<int>& nums) {
        unordered_map<int, int> mp;
        int maxF = 0;
        for(auto i : nums){
            mp[i]++;
            maxF = max(maxF, mp[i]);
        }
        vector<vector<int>> ans(maxF);

        for(auto i : mp){
            for(int j=0; j<i.second; j++) ans[j].push_back(i.first);
        }

        return ans;
    }
};