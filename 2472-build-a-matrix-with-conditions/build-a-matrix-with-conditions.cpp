class Solution {
public:
    void dfs(int i, unordered_map<int, vector<int>>& adjList, vector<int>& vis, bool& cycle, vector<int>& topoArr){
        vis[i] = 1;

        for(int j : adjList[i]){
            if(vis[j] == 0){
                dfs(j, adjList, vis, cycle, topoArr);
            }
            else if(vis[j] == 1){
                cycle = true;
                return;
            }
        }

        vis[i] = 2;
        topoArr.insert(topoArr.begin(), i);
    }
    vector<int> topoSort(int& k, vector<vector<int>>& edges){
        int sz = edges.size();
        unordered_map<int, vector<int>> adjList;
        vector<int> topoArr;

        for(int i=0; i<sz; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList[u].push_back(v);
        }

        vector<int> vis(k+1, 0);
        bool cycle = false;

        for(int i=1; i<=k; i++){
            if(vis[i] == 0){
                dfs(i, adjList, vis, cycle, topoArr);
                if(cycle) return {};
            }
        }

        return topoArr;
    }
    vector<vector<int>> buildMatrix(int k, vector<vector<int>>& rowConditions, vector<vector<int>>& colConditions) {
        vector<vector<int>> ans(k, vector<int>(k, 0));
        vector<int> topoRow = topoSort(k, rowConditions);
        vector<int> topoCol = topoSort(k, colConditions);

        if(topoRow.size() == 0 || topoCol.size() == 0) return {};

        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                if(topoRow[i] == topoCol[j]){
                    ans[i][j] = topoCol[j];
                }
            }
        }
        
        return ans;
    }
};