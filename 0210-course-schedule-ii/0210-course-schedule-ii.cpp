class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& pr) {
        map<int, vector<int>> adj;
        vector<int> indeg(numCourses, 0);

        for(auto i : pr){
            adj[i[0]].push_back(i[1]);
            adj[i[1]].push_back(i[0]);
            indeg[i[0]]++;
        }
        
        vector<int> vis(numCourses, 0);
        vector<int> ans;
        queue<int> q;
        for(int i=0; i<indeg.size(); i++){
            if(indeg[i] == 0){
                q.push(i);
                vis[i] = 1;
            }
        }
        while(!q.empty()){
            int curr = q.front();
            q.pop();
            ans.push_back(curr);
            for(auto i : adj[curr]){
                if(indeg[i]) indeg[i]--;
                if(indeg[i] == 0 && vis[i] != 1){
                    q.push(i);
                    vis[i] = 1;
                }
            }
        }
        if(ans.size() != numCourses) return {};
        return ans;
    }
};