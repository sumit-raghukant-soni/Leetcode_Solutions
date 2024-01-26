class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int sz = strs.size();
        string tmp = "";

        vector<vector<string>> ans;
        unordered_map<string, vector<string>> mp;

        for(int i=0; i<sz; i++){
            tmp = strs[i];
            sort(tmp.begin(), tmp.end());
            mp[tmp].push_back(strs[i]);    
        }

        for(auto i : mp){
            ans.push_back(i.second);
        }

        return ans;
    }
};