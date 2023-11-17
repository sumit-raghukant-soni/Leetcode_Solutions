class Solution {
public:
    vector<vector<int>> findMatrix(vector<int>& nums) {
        unordered_map<int, int> mp;
        for(auto i : nums) mp[i]++;

        vector<vector<int>> ans;
        while(mp.size() > 0){
            vector<int> tmp;
            for(auto i : mp){
                if(mp[i.first] >= 1) {
                    mp[i.first]--;
                    tmp.push_back(i.first);
                }
            }
            if(tmp.size() == 0) break;
            ans.push_back(tmp);
        }
        return ans;
    }
};