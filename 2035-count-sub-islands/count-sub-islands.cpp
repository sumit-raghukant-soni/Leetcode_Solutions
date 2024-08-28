class Solution {
public:
    void dfs(vector<vector<int>>& grid1, vector<vector<int>>& grid2, int& m, int& n, vector<vector<int>>& vis, int& flg, int row, int col){
        // cout << row << ":" << col << endl;
        vis[row][col]++;
        int dr[] = {0, -1, 0, 1}, dc[] = {-1, 0, 1, 0};
        for(int i=0; i<4; i++){
            int r = row + dr[i], c = col + dc[i];
            if(r >= 0 && r < m && c >= 0 && c < n && !vis[r][c] && grid2[r][c]){
                if(!grid1[r][c]){
                    flg = 0;
                    // cout << "flg changed" << endl;
                }
                dfs(grid1, grid2, m, n, vis, flg, r, c);
            }
        }

    }
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int m = grid2.size(), n = grid2[0].size(), ans = 0;
        vector<vector<int>> vis(m, vector<int>(n, 0));

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && grid2[i][j]){
                    int flg = 1;
                    if(grid1[i][j]) dfs(grid1, grid2, m, n, vis, flg, i, j);
                    else flg = 0;
                    ans+=flg;
                }
            }
        }

        return ans;
    }
};