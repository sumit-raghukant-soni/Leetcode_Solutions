class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k == 0 || n >= k-1+maxPts) return 1;

        double dp[] = new double[maxPts];
        dp[0] = 1;
        double currSum = 1, ans = 0, prob;

        for(int i=1; i<=n; i++){
            prob = currSum / maxPts;

            if(i < k) currSum += prob;
            else ans += prob;

            if(i >= maxPts) currSum -= dp[i % maxPts];

            dp[i % maxPts] = prob;
        }

        return ans;
    }
}