class Solution {
public:
    int solve(vector<vector<int>>& dp, string& str, int s, int e){
        if(s == e) return 1;
        if(dp[s][e] != -1) return dp[s][e];

        int turns = INT_MAX;
        for(int i=s; i<e; i++){
            turns = min(turns, solve(dp, str, s, i) + solve(dp, str, i+1, e));
        }

        return dp[s][e] = (str[s] == str[e] ? turns-1 : turns);
    }
    int strangePrinter(string s) {
        int sz = s.length();
        vector<vector<int>> dp(sz, vector<int>(sz, -1));
        return solve(dp, s, 0, sz-1);
    }
};