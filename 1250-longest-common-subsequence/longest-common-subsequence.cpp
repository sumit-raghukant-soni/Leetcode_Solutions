class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int sz1 = text1.length(), sz2 = text2.length();
        vector<vector<int>> dp(sz1+1, vector<int>(sz2+1, 0));

        for(int i=1; i<=sz1; i++){
            for(int j=1; j<=sz2; j++){
                if(text1[i-1] == text2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else dp[i][j] = max({dp[i-1][j], dp[i][j-1], dp[i-1][j-1]});
            }
        }

        // for(auto i : dp){
        //     for(int j : i) cout << j << " ";
        //     cout << endl;
        // }

        return dp[sz1][sz2];
    }
};