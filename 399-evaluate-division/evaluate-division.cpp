class Solution {
public:
    void solve(string src, string target, unordered_map<string, vector<pair<string, double> > >& adj, 
    unordered_map<string, int>& vis, double& cost, bool& flg){
        if(flg) return;
        vis[src]++;
        for(auto i : adj[src]){
            cost *= i.second;
            if(!flg && !vis[i.first] && i.first == target) {
                // cout << "completed " << i.first << " " << cost << endl;
                flg = true;
                return;
            }
            if(!flg && !vis[i.first]) {
                // cout << src << " to " << i.first << " " << cost << endl;
                solve(i.first, target, adj, vis, cost, flg);
            }
            if(!flg) cost /= i.second;
            else break;
        }
    }
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        if(queries.size() == 0 || equations.size() == 0) return {};

        vector<double> ans;
        unordered_map<string, vector<pair<string, double> > > adj;
        unordered_map<string, int> vis;
        set<string> nodes;
        int sz = equations.size();
        for(int i=0; i<sz; i++){
            string s = equations[i][0], e = equations[i][1];
            adj[s].push_back({e, values[i]});
            adj[e].push_back({s, 1/values[i]});
            nodes.insert(s);
            nodes.insert(e);
        }

        sz = queries.size();
        bool flg;
        for(int i=0; i<sz; i++){
            // cout << "first" << queries[i][0] << " "  << queries[i][1] << endl;
            if(nodes.find(queries[i][0]) == nodes.end() || nodes.find(queries[i][1]) == nodes.end()){
                ans.push_back(-1);
            }
            else if(queries[i][0] == queries[i][1]) ans.push_back(1);
            else{
                vis.clear();
                flg = false;
                double cost = 1; 
                solve(queries[i][0], queries[i][1], adj, vis, cost, flg);
                if(flg) ans.push_back(cost);
                else ans.push_back(-1);
                // cout << cost << " ";
            }
            // cout << "last" << endl;
        }

        return ans;
    }
};