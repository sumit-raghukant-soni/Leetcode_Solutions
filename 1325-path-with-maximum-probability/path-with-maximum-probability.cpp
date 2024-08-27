class Solution {
public:
    double ans;
    void solve(unordered_map<int, vector<pair<int, double>>>& adjList, vector<int>& vis, int& end_node, double prob, int ind){
        if(prob <= 1e-5) return;

        if(ind == end_node){
            ans = max(ans, prob);
            return;
        }
        
        vis[ind]++;
        for(pair<int, double> i : adjList[ind]){
            if(!vis[i.first]){
                // cout << ind << " : " << i.first << " " << i.second << endl;
                if(prob*i.second >= ans) solve(adjList, vis, end_node, prob * i.second, i.first); 
            }
        }
        vis[ind]--;
    }
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start_node, int end_node) {
        ans = 0;
        vector<int> vis(n, 0);
        unordered_map<int, vector<pair<int, double>>> adjList;

        for(int i=0; i<edges.size(); i++){
            adjList[edges[i][0]].push_back({edges[i][1], succProb[i]});
            adjList[edges[i][1]].push_back({edges[i][0], succProb[i]});
        }

        solve(adjList, vis, end_node, 1.0, start_node);

        return ans;
    }
};