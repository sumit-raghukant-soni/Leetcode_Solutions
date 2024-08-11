class Solution {
public:
    int m, n;
    void bfs(vector<vector<int>>& grid, vector<vector<int>>& vis, int row, int col){
        vis[row][col] = 1;
        int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
        for(int i=0; i<4; i++){
            int r = dr[i] + row, c = dc[i] + col;
            if(r >= 0 && r < m && c >= 0 && c < n && !vis[r][c] && grid[r][c]){
                bfs(grid, vis, r, c);
            }
        }
    }
    int solve(vector<vector<int>>& grid){
        int num = 0;
        vector<vector<int>> vis(m, vector<int>(n, 0));

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    bfs(grid, vis, i, j);
                    num++;
                }
            }
        }
        return num;
    }
    int minDays(vector<vector<int>>& grid) {
        m=grid.size(), n=grid[0].size();
        if(solve(grid) != 1) return 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(solve(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }
};