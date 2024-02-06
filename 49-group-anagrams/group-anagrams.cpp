class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string, vector<string>> mp;
        vector<vector<string>> ans;
        int sz = strs.size();

        for(int i=0; i<sz; i++){
            string tmp = strs[i];
            sort(tmp.begin(), tmp.end());
            mp[tmp].push_back(strs[i]);
        }

        for(auto i : mp) ans.push_back(i.second);

        return ans;
    }
};