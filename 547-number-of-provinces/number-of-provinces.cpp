class Solution {
public:
    void bfs(int ind, int sz, vector<vector<int>>& adj, unordered_map<int, int>& vis){
        if(vis[ind]) return;
        vis[ind]++;

        for(int i=0; i<sz; i++){
            if(ind != i && adj[ind][i] && !vis[i]) bfs(i, sz, adj, vis);
        }
    }
    int findCircleNum(vector<vector<int>>& isConnected) {
        int cnt = 0, sz = isConnected.size();
        unordered_map<int, int> vis;

        cnt++;
        bfs(0, sz, isConnected, vis);

        for(int i=0; i<sz; i++){
            if(!vis[i]){
                cnt++;
                bfs(i, sz, isConnected, vis);
            }
        }

        return cnt;
    }
};