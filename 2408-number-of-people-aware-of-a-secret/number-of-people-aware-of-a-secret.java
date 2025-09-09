class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1000000007;
        long dp[] = new long[n];

        dp[0] = 1;

        for(int i=0; i<n; i++){
            for(int j=delay; j<forget && i+j<n; j++){
                dp[i+j] += dp[i];
                dp[i+j] = dp[i+j] % MOD;
            }
        }

        // for(int i=0; i<n; i++){
        //     System.out.print(dp[i] + ", ");
        // }

        for(int i=1; i<forget; i++){
            dp[n-1] += dp[n-1-i];
            dp[n-1] = dp[n-1] % MOD;
        }

        return (int) dp[n-1];
    }
}