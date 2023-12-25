class Solution {
public:
    void bfs(int ind, unordered_map<int, vector<int>>& adj, unordered_map<int, int>& vis){
        if(vis[ind]) return;
        vis[ind]++;

        for(int i=0; i<adj[ind].size(); i++){
            if(!vis[adj[ind][i]]) bfs(adj[ind][i], adj, vis);
        }
    }
    int findCircleNum(vector<vector<int>>& isConnected) {
        int cnt = 0, sz = isConnected.size();
        unordered_map<int, vector<int>> adj;
        unordered_map<int, int> vis;
        for(int i=0; i<sz; i++){
            for(int j=0; j<sz; j++){
                if(isConnected[i][j] && j != i) adj[i].push_back(j);
            }
        }

        cnt++;
        bfs(0, adj, vis);

        for(int i=0; i<sz; i++){
            if(!vis[i]){
                cnt++;
                bfs(i, adj, vis);
            }
        }

        return cnt;
    }
};