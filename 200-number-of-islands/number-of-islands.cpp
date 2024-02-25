class Solution {
public:
    void solve(vector<vector<char>>& grid, int i, int j, int n, int m, vector<vector<int>>& vis){
        if(i < 0 || i == n || j < 0 || j == m || vis[i][j] != 0 || grid[i][j] != '1') return;

        vis[i][j]++;
        int dr[4] = {0,-1,0,1}, dc[4] = {-1,0,1,0};
        int row, col;
        for(int k=0; k<4; k++){
            row = i + dr[k], col = j + dc[k];
            solve(grid, row, col, n, m, vis);
        }

    }
    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size(), m = grid[0].size(), cnt = 0;
        vector<vector<int>> vis(n, vector<int>(m, 0));

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    solve(grid, i, j, n, m, vis);
                    cnt++;
                }
            }
        }

        return cnt;
    }
};