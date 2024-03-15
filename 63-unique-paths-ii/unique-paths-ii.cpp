class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& grid) {
        int row = grid.size(), col = grid[0].size();
        if(grid[0][0] == 1 || grid[row-1][col-1] == 1) return 0;
        vector<vector<int>> ans(row, vector<int>(col, 0));
        if(grid[0][0] != 1) ans[0][0] = 1;
        for(int i=1; i<row; i++){
            if(grid[i][0] != 1) ans[i][0] = ans[i-1][0];
        }
        for(int i=1; i<col; i++){
            if(grid[0][i] != 1) ans[0][i] = ans[0][i-1];
        }

        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(grid[i][j] == 1){
                    ans[i][j] = 0;
                }
                else{
                    ans[i][j] = ans[i-1][j] + ans[i][j-1];
                }
            }
        }

        return ans[row-1][col-1];
    }
};