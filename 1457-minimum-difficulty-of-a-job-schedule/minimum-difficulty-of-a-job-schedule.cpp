class Solution {
public:
    int dp[301][11];
    int solve(vector<int>& jobs, int& sz, int d, int ind){
        if(dp[ind][d] != -1) return dp[ind][d];

        if(d == 1){
            int maxi = 0;
            for(int i=ind; i<sz; i++) maxi = max(maxi, jobs[i]);
            return maxi;
        }

        int maxi = jobs[ind], res = INT_MAX;
        for(int i = ind; i<sz-(d-1); i++){
            maxi = max(maxi, jobs[i]);
            res = min(res, solve(jobs, sz, d-1, i+1) + maxi);
        }
        return dp[ind][d] = res;
    }
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        memset(dp, -1, sizeof(dp));
        int sz = jobDifficulty.size();
        if(d > sz) return -1;

        return solve(jobDifficulty, sz, d, 0);
    }
};