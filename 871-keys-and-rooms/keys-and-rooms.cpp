class Solution {
public:
    void traverse(int ind, map<int, vector<int>>& adj, unordered_map<int, int>& vis){
        if(vis[ind]) return;
        vis[ind]++;

        for(int i=0; i<adj[ind].size(); i++){
            if(!vis[adj[ind][i]]){
                traverse(adj[ind][i], adj, vis);
            }
        }
    }
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int sz = rooms.size();
        map<int, vector<int>> adj;
        unordered_map<int, int> vis;

        for(int i=0; i<sz; i++){
            for(auto j : rooms[i])
                adj[i].push_back(j);
        }

        traverse(0, adj, vis);

        return vis.size() == sz;
    }
};