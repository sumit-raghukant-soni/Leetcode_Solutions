class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        vector<vector<int>> dp = grid;
        int row = grid.size(), col = grid[0].size();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int v1 = i-1 >= 0 ? dp[i-1][j] : 1000000, v2 = j-1 >= 0 ? dp[i][j-1] : 1000000;
                if(i == 0 && j == 0) dp[i][j] = grid[i][j]; 
                else dp[i][j] = grid[i][j] + min(v1, v2);
            }
        }

        return dp[row-1][col-1];
    }
};