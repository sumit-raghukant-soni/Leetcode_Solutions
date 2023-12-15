class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        map<string, int> mp;
        int sz = paths.size();

        for(int i=0; i<sz; i++){
            mp[paths[i][0]]++;
            if(mp.find(paths[i][1]) == mp.end()) mp[paths[i][1]] = 0;
        }

        for(auto i : mp) if(i.second == 0) return i.first;

        return "";
    }
};