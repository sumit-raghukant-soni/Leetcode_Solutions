class Solution {
public:
    int solve(vector<vector<int>>& dp, string& s, string& p, bool& ans, int& ssz, int& psz, int i, int j){
        if(i == ssz && j == psz){
            // cout << "here" << endl;
            return dp[i][j] = 1;
        }
        if(i >= ssz){
            // cout << "here" << endl;
            if(j < psz && p[j] == '*') { 
                // cout << "checked"; 
                return solve(dp, s, p, ans, ssz, psz, i, j+1);}
            return 0;
        }
        // cout << s[i] << ":" << p[j] << endl;
        if(dp[i][j] != -1) return dp[i][j];

        if(p[j] == '*'){
            return dp[i][j] = solve(dp, s, p, ans, ssz, psz, i+1, j+1) || solve(dp, s, p, ans, ssz, psz, i+1, j) || solve(dp, s, p, ans, ssz, psz, i, j+1);
        }
        else if(p[j] == '?' || p[j] == s[i]){
            return dp[i][j] = solve(dp, s, p, ans, ssz, psz, i+1, j+1);
        }
        else {
            return dp[i][j] = 0;
        }
    }
    bool isMatch(string s, string p) {
        if(p == "*") return true;
        if(p == "" && s != "") return false;
        int ssz = s.length(), psz = p.length();
        // cout << s << " " << p << endl;
        vector<vector<int>> dp(ssz+1, vector<int>(psz+1, -1));

        bool ans = false;
        solve(dp, s, p, ans, ssz, psz, 0, 0);

        // for(int i=0; i<=ssz; i++){
        //     for(int j=0; j<=psz; j++){
        //         cout << dp[i][j] << " ";
        //     }
        //     cout << endl;
        // }

        return dp[ssz][psz] == -1 ? false : dp[ssz][psz];
    }
};