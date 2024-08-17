class Solution {
public:
    long long maxPoints(vector<vector<int>>& points) {
        int m = points.size(), n = points[0].size();
        vector<vector<long long>> dp(m, vector<long long>(n, 0));

        for(int j=0; j<n; j++){
            dp[0][j] = points[0][j];
        }

        for(int i=1; i<m; i++){
            vector<long long> leftMax(n, 0), rightMax(n, 0);
            rightMax[n-1] = dp[i-1][n-1];
            for(int j=n-2; j>=0; j--){
                rightMax[j] = max(rightMax[j+1] - 1, dp[i-1][j]);
            }
            leftMax[0] = dp[i-1][0];
            for(int j=0; j<n; j++){
                if(j-1 >= 0) leftMax[j] = max(leftMax[j-1] - 1, dp[i-1][j]);
                dp[i][j] = max(rightMax[j], leftMax[j]) + points[i][j];
            }
        }

        // for(auto i : dp){
        //     for(int j : i){
        //         cout << j << ", ";
        //     }
        //     cout << endl;
        // }

        return *max_element(dp[m-1].begin(), dp[m-1].end());
    }
};