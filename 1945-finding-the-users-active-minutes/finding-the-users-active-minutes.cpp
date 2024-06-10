class Solution {
public:
    vector<int> findingUsersActiveMinutes(vector<vector<int>>& logs, int k) {
        vector<int> ans(k, 0);
        int sz = logs.size();
        unordered_map<int, unordered_set<int> > mp;

        for(int i=0; i<sz; i++){
            mp[logs[i][0]].insert(logs[i][1]);
        }

        for(auto i : mp){
            int count = i.second.size();
            ans[count-1]++;
        }

        return ans;
    }
};