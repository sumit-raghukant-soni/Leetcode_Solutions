class Solution {
public:
    int solve(vector<vector<int>>& matrix, vector<vector<int>>& dp, vector<vector<int>>& vis, int& m, int& n, int& ans, int i, int j){
        // cout  << i << " " << j << endl;
        if(dp[i][j] != -1) return dp[i][j];

        vis[i][j] = 1;

        int dr[] = {0, -1, 0, 1}, dc[] = {1, 0, -1, 0}, maxLen = 0;
        for(int t=0; t<4; t++){
            int row = i + dr[t], col = j + dc[t];
            if(row < m && row >= 0 && col < n && col >= 0 && vis[row][col] == 0 && matrix[i][j] < matrix[row][col]){
                maxLen = max(maxLen, solve(matrix, dp, vis, m, n, ans, row, col));
            }
        }

        vis[i][j] = 0;

        // cout << i << ":" << j << " " << 1 + maxLen << endl;
        ans = max(ans, 1 + maxLen);        
        return dp[i][j] = 1 + maxLen;
    }
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size(), ans = 1;
        vector<vector<int>> dp(m+1, vector<int>(n+1, -1)), vis(m, vector<int>(n, 0));

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                solve(matrix, dp, vis, m, n, ans, i, j);
            }
        }

        return ans;
    }
};