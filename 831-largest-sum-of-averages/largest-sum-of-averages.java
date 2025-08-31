class Solution {
    double dp[][] = null;
    public double largestSumOfAverages(int[] nums, int k) {
        int sz = nums.length;

        dp = new double[sz][k+1];

        for(int i=0; i<sz; i++){
            for(int j=0; j<=k; j++){
                dp[i][j] = -1l;
            }
        }

        return solve(nums, sz, k, 0);
    }

    private double solve(int nums[], int sz, int k, int ind){
        if(ind == sz || k == 0) return 0;
        if(dp[ind][k] != -1l) return dp[ind][k];
        if(k == 1){
            double sum = 0, cnt = 0;
            for(int i=ind; i<sz; i++){
                sum += nums[i]; cnt++;
            }
            return dp[ind][k] = sum/cnt;
        }

        double ans = 0, sum = 0, curr;
        int cnt = 0;
        for(int i=ind; i<=sz-k; i++){
            cnt++;
            sum += nums[i];
            curr = (sum/cnt) + solve(nums, sz, k-1, i+1);
            ans = ans > curr ? ans : curr;
        }

        return dp[ind][k] = ans;
    }
}