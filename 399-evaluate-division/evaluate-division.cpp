class Solution {
public:
    void solve(unordered_map<string, vector<pair<string, double>>>& adjList, unordered_map<string, bool>& mp, bool& flg, string src, string dst, double& val, double& a){
        if(mp.find(src) != mp.end() || flg) return;
        if(src == dst) { flg = true; a = val; return;}

        mp[src] = true;
        for(int i=0; i<adjList[src].size(); i++){
            val *= adjList[src][i].second;
            solve(adjList, mp, flg, adjList[src][i].first, dst, val, a);
            if(!flg) val /= adjList[src][i].second;
            else break;
        }
    }
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        vector<double> ans;
        unordered_map<string, bool> mp;
        unordered_map<string, vector<pair<string, double>>> adjList;
        int sz = equations.size();

        for(int i=0; i<sz; i++){
            adjList[equations[i][0]].push_back({equations[i][1], values[i]});
            adjList[equations[i][1]].push_back({equations[i][0], 1.0/values[i]});
            mp[equations[i][1]] = mp[equations[i][0]] = true;
        }

        sz = queries.size();
        for(int i=0; i<sz; i++){
            if(mp.find(queries[i][0]) == mp.end() || mp.find(queries[i][1]) == mp.end()) ans.push_back(-1.0);
            else{
                unordered_map<string, bool> mp2;
                double tmp = 1.0, a = -1.0;
                bool flg = false;
                solve(adjList, mp2, flg, queries[i][0], queries[i][1], tmp, a);
                ans.push_back(a);
            } 
        }

        return ans;
    }
};