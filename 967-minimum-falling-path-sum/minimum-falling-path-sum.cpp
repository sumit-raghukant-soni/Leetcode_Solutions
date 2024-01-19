class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int sz = matrix.size(), mini = INT_MAX;
        if(sz == 1) return matrix[0][0];
        vector<vector<int>> dp(sz, vector<int>(sz, INT_MAX));
        dp[0] = matrix[0];
        for(int i=1; i<sz; i++){
            for(int j=0; j<sz; j++){
                dp[i][j] = min(dp[i][j], dp[i-1][j]);
                if(j-1 >= 0) dp[i][j] = min(dp[i][j], dp[i-1][j-1]);
                if(j+1 < sz) dp[i][j] = min(dp[i][j], dp[i-1][j+1]);
                dp[i][j] += matrix[i][j];
                if(i == sz-1) mini = min(dp[i][j], mini);
            }
        }

        return mini;
    }
};