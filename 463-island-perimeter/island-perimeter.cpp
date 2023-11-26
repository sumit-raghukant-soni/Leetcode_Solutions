class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int ans = 0;
        int m = grid.size(), n = grid[0].size();

        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    ans += 4;
                    if(i+1 < m && grid[i+1][j] == 1) ans -= 2;
                    if(j+1 < n && grid[i][j+1] == 1) ans -= 2;
                }
            }
        }

        return ans;
    }
};