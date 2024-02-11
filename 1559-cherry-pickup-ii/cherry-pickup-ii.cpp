class Solution {
public:
    int solve(vector<vector<vector<int>>>& dp, vector<vector<int>>& grid, int row, int sz, int col, int a, int b){
        if(a < 0 || b < 0 || a >= col || b >= col) return 0;
        if(row == sz) return 0;

        if(dp[row][a][b] != -1) return dp[row][a][b];

        int result = 0;

        for(int i=a-1; i<=a+1; i++){
            for(int j=b-1; j<=b+1; j++){
                if(i < j){
                    result = max(result, solve(dp, grid, row+1, sz, col, i, j));
                }
            }
        }

        return dp[row][a][b] = result + grid[row][a] + grid[row][b];
    }
    int cherryPickup(vector<vector<int>>& grid) {
        int ans;
        vector<vector<vector<int>>> dp(grid.size(), vector<vector<int>>(grid[0].size(), vector<int>(grid[0].size(), -1)));
        ans = solve(dp, grid, 0, grid.size(), grid[0].size(), 0, grid[0].size()-1);

        return ans;
    }
};