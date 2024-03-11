class Solution {
public:
    int dp[101][101];
    bool solve(string s1, string s2, string s3, int sz1, int sz2, int sz3, int i, int j){
        if(i+j >= sz3 && i >= sz1 && j >= sz2) return true;

        if(dp[i][j] != -1) return dp[i][j];

        if(i<sz1 && s1[i] == s3[i+j] && j<sz2 && s2[j] == s3[i+j]){
            return dp[i][j] = solve(s1, s2, s3, sz1, sz2, sz3, i+1, j) || solve(s1, s2, s3, sz1, sz2, sz3, i, j+1);
        }
        else if(j<sz2 && s3[i+j] == s2[j]){
            return dp[i][j] = solve(s1, s2, s3, sz1, sz2, sz3, i, j+1);
        }
        else if(i<sz1 && s3[i+j] == s1[i]){
            return dp[i][j] = solve(s1, s2, s3, sz1, sz2, sz3, i+1, j);
        }
        return dp[i][j] = false;
    }
    bool isInterleave(string s1, string s2, string s3) {
        int sz1 = s1.length(), sz2 = s2.length(), sz3 = s3.length();
        memset(dp, -1, sizeof(dp));
        
        return solve(s1,s2,s3, sz1, sz2, sz3, 0, 0);
    }
};