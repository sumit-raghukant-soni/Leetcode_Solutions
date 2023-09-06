class Solution {
public:
    bool dfs(vector<vector<int>>& graph, unordered_map<int, int>& vis, set<int>& safe, int ind){
        if(safe.find(ind) != safe.end()) return true;
        if(vis[ind] == 1) return false;
        vis[ind] = 1;
        if(graph[ind].size() == 0){
            safe.insert(ind);
            return true;
        }
        int sf = 0;
        for(auto i : graph[ind]){
            // cout << ind << " : " << i << safe[ind] << endl;
            bool tmp = false;
            tmp = dfs(graph, vis, safe, i);
            if(tmp){
                // cout << "Correct" << endl;
                sf++;
            }
        }
        if(sf == graph[ind].size()){
            // cout << "There " << ind << endl;
            safe.insert(ind);
        } 
        return sf == graph[ind].size();
    }
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        unordered_map<int, int> vis;
        set<int> safe;
        for(int i=0; i<graph.size(); i++){
            if(vis.find(i) == vis.end()){
                dfs(graph, vis, safe, i);
            }
        }
        return vector<int>(safe.begin(), safe.end());
    }
};