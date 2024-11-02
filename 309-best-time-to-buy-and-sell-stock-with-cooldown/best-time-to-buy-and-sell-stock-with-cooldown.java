class Solution {
    public int solve(int[][] dp, int[] prices, int sz, int buy, int cp, int i){
        if(i >= sz) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 1){
            return dp[i][buy] = Math.max(prices[i] + solve(dp, prices, sz, 0, 0, i+2), solve(dp, prices, sz, buy, cp, i+1));
        }

        return dp[i][buy] = Math.max(-prices[i] + solve(dp, prices, sz, 1, prices[i], i+1), solve(dp, prices, sz, 0, 0, i+1));
    }
    public int maxProfit(int[] prices) {
        int sz = prices.length;
        int dp[][] = new int[sz][2];

        for(int i=0; i<sz; i++){
            for(int j=0; j<2; j++){
                dp[i][j] = -1;
            }
        }

        solve(dp, prices, sz, 0, 0, 0);

        return dp[0][0];
    }
}