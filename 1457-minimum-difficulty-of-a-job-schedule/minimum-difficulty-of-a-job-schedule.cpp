class Solution {
public:
    int solve(vector<vector<int>>& dp, vector<int>& jobs, int& sz, int d, int ind){
        if(dp[ind][d] != -1) return dp[ind][d];

        if(d == 1){
            int maxi = 0;
            for(int i=ind; i<sz; i++) maxi = max(maxi, jobs[i]);
            return maxi;
        }

        int maxi = jobs[ind], res = INT_MAX;
        for(int i = ind; i<sz-(d-1); i++){
            maxi = max(maxi, jobs[i]);
            res = min(res, solve(dp, jobs, sz, d-1, i+1) + maxi);
        }
        return dp[ind][d] = res;
    }
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        int sz = jobDifficulty.size();
        if(d > sz) return -1;

        vector<vector<int>> dp(sz+1, vector<int>(d+1, -1));

        return solve(dp, jobDifficulty, sz, d, 0);
    }
};