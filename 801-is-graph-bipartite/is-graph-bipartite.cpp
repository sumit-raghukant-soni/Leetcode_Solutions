class Solution {
public:
    bool check(vector<vector<int>>& graph,  vector<int>& vis, queue<pair<int, int>>& q){
        while(!q.empty()){
            auto front = q.front();
            q.pop();
            // cout << "this" << front.first << " " << front.second << " " << graph[front.first].size() << endl;
            int next = front.second == 1 ? 2 : 1;
            for(int i = 0; i<graph[front.first].size(); i++){
                // cout << "neighbors " << graph[front.first][i] << " ";
                if(vis[graph[front.first][i]] == 0){
                    vis[graph[front.first][i]] = next;
                    q.push({graph[front.first][i], next});
                }
                else if(vis[graph[front.first][i]] == vis[front.first]){
                    return false;
                }
            }
            // cout << endl;
            // for(auto j : vis) cout << j << " ";
            // cout << endl;
        }
        return true;
    }
    bool isBipartite(vector<vector<int>>& graph) {
        int sz = graph.size();
        vector<int> vis(sz, 0);

        queue<pair<int, int>> q;
        
        
        for(int i=0; i<sz; i++){
            if(vis[i] == 0){
                q.push({i, 1});
                vis[i] = 1;
                bool tmp = check(graph, vis, q);
                if(!tmp) return false;
            }
        }

        return true;
    }
};