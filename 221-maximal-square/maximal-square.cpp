class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int ans = 0, row = matrix.size(), col = matrix[0].size();
        vector<vector<int>> dp(row, vector<int>(col, 0));

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == '1') dp[i][j]++;
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (dp[i][j]) {
                    int v1 = 0, v2 = 0, v3 = 0;
                    if (i + 1 < row)
                        v1 = dp[i + 1][j];
                    if (j + 1 < col)
                        v2 = dp[i][j + 1];
                    if(i+1 < row && j+1 < col)
                        v3 = dp[i+1][j+1];
                    dp[i][j] = min({v1, v2, v3}) + 1;
                }
                ans = max(ans, dp[i][j]);
            }
        }

        return ans * ans;
    }
};