class Solution {
public:
    void visit(vector<vector<char>>& grid, int& row, int& col, vector<vector<int>>& vis, int r, int c){
        vis[r][c]++;
        int dr[] = {0, -1, 0, 1}, dc[] = {-1, 0, 1, 0};
        for(int i=0; i<4; i++){
            int rw = r + dr[i], cl = c + dc[i];
            if(rw < row && rw >= 0 && cl < col && cl >= 0 && grid[rw][cl] == '1' && vis[rw][cl] == 0){
                visit(grid, row, col, vis, rw, cl);
            }
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        int row = grid.size(), col = grid[0].size();
        int ans = 0;
        vector<vector<int>> vis(row, vector<int>(col, 0));
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    visit(grid, row, col, vis, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }
};