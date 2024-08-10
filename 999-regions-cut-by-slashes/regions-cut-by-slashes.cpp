class Solution {
public:
    void bfs(vector<vector<int>>& graph, vector<vector<int>>& vis, int row, int col, int i, int j){
        queue<pair<int, int>> q;
        q.push({i, j});
        vis[i][j] = 1;
        int dr[] = {0,1,0,-1}, dc[] = {1,0,-1,0};
        while(!q.empty()){
            int frontI = q.front().first, frontJ = q.front().second;
            q.pop();
            // cout << "visited " << frontI << " " << frontJ << endl;
            for(int i=0; i<4; i++){
                int r = frontI+dr[i], c = frontJ + dc[i];
                if(r < row && r >= 0 && c < col && c >= 0 && vis[r][c] == 0 && graph[r][c] == 0){
                    vis[r][c] = 1;
                    q.push({r, c});
                }
            }
        }
    }
    int regionsBySlashes(vector<string>& grid) {
        int sz = grid.size(), ans = 0;
        vector<vector<int>> graph(sz*3), vis(sz*3, vector<int>(sz*3, 0));

        for(int i=0; i<sz; i++){
            for(int j=0; j<sz; j++){
                // graph[i].push_back(0);
                if(grid[i][j] == '\\'){
                    graph[i*3].push_back(1);
                    graph[i*3].push_back(0);
                    graph[i*3].push_back(0);
                    graph[i*3+1].push_back(0);
                    graph[i*3+1].push_back(1);
                    graph[i*3+1].push_back(0);
                    graph[i*3+2].push_back(0);
                    graph[i*3+2].push_back(0);
                    graph[i*3+2].push_back(1);
                }
                else if(grid[i][j] == '/'){
                    graph[i*3].push_back(0);
                    graph[i*3].push_back(0);
                    graph[i*3].push_back(1);
                    graph[i*3+1].push_back(0);
                    graph[i*3+1].push_back(1);
                    graph[i*3+1].push_back(0);
                    graph[i*3+2].push_back(1);
                    graph[i*3+2].push_back(0);
                    graph[i*3+2].push_back(0);
                }
                else{
                    graph[i*3].push_back(0);
                    graph[i*3].push_back(0);
                    graph[i*3].push_back(0);
                    graph[i*3+1].push_back(0);
                    graph[i*3+1].push_back(0);
                    graph[i*3+1].push_back(0);
                    graph[i*3+2].push_back(0);
                    graph[i*3+2].push_back(0);
                    graph[i*3+2].push_back(0);
                }
            }
        }

        for(int i=0; i<sz*3; i++){
            for(int j=0; j<sz*3; j++){
                // cout << graph[i][j] << " ";
                if(vis[i][j] == 0 && graph[i][j] == 0){
                    ans++;
                    bfs(graph, vis, sz*3, sz*3, i, j);
                }
            }
            // cout << endl;
        }

        return ans;
    }
};