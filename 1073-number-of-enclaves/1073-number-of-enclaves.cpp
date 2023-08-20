class Solution {
public:
    int r,c;
    void dfs(vector<vector<int>>& vis, vector<vector<int>>& grid, int i, int j, int dr[], int dc[]){
        vis[i][j] = 1;
        for(int k=0; k<4; k++){
            int row = i + dr[k];
            int col = j + dc[k];
            if(row < r && row >= 0 && col < c && col >= 0 && vis[row][col] == 0 && grid[row][col] == 1)
                dfs(vis, grid, row, col, dr, dc);
        }
    }
    int numEnclaves(vector<vector<int>>& grid) {
        int cnt = 0;
        r = grid.size(), c= grid[0].size();
        vector<vector<int>> vis(r, vector<int>(c,0));
        int dc[] = {1,0,-1,0};
        int dr[] = {0,1,0,-1};

        for(int i=0; i<r; i++){
            if(grid[i][c-1] == 1 && vis[i][c-1] == 0)
                dfs(vis, grid, i, c-1, dr, dc);
            if(grid[i][0] == 1 && vis[i][0] == 0)
                dfs(vis, grid, i, 0, dr, dc);
        }

        for(int i=0; i<c; i++){
            if(grid[0][i] == 1 && vis[0][i] == 0)
                dfs(vis, grid, 0, i, dr, dc);
            if(grid[r-1][i] == 1 && vis[r-1][i] == 0)
                dfs(vis, grid, r-1, i, dr, dc);
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++)
                if(grid[i][j] == 1 && vis[i][j] == 0) cnt++;
        }
        return cnt;
    }
};