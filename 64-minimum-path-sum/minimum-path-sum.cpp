class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        vector<vector<int>> dp = grid;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 && j == 0) continue;
                int top = i-1 >= 0 ? dp[i-1][j] : 1e8, left = j-1 >= 0 ? dp[i][j-1] : 1e8;
                dp[i][j] = grid[i][j] + min(top, left);
            }
        }

        return dp[n-1][m-1];
    }
};