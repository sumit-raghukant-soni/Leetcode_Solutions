class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int ans = 0;
        int row = grid.size(), col = grid[0].size();
        queue<pair<int, pair<int, int>>> q;
        vector<vector<int>> vis(row, vector<int>(col, 0));

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 1;
                    q.push({0, {i, j}});
                }
            }
        }

        while(!q.empty()){
            int i = q.front().second.first, j = q.front().second.second;
            int time = q.front().first;
            q.pop();
            if(i == j && i == 100){
                if(q.empty()) break;
                i = q.front().second.first, j = q.front().second.second;
                time = q.front().first;
            }
            ans = max(ans, time);
            int dr[4] = {0, 1, 0, -1}, dc[4] = {1, 0, -1, 0};
            for(int k=0; k<4; k++){
                int r = dr[k] + i, c = dc[k] + j;
                if(r < row && r >= 0 && c < col && c >= 0 && !vis[r][c] && grid[r][c] == 1){
                    grid[r][c] = 2;
                    q.push({time+1, {r, c}});
                    vis[r][c] = 1;
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1) return -1;       
            }
        }

        return ans;
    }
};