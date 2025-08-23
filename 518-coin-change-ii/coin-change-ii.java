class Solution {
    int dp[][] = null;
    public int change(int amount, int[] coins) {
        dp = new int[amount+1][5001];

        Arrays.sort(coins);
        for(int i=0; i<amount+1; i++) Arrays.fill(dp[i], -1);

        return solve(coins, coins.length, amount, 0);
    }


    private int solve(int[] coins, int sz, int amount, int last){
        if(amount == 0) return 1;
        if(amount < 0) return 0;
        if(dp[amount][last] != -1) return dp[amount][last];

        int cnt = 0;
        for(int j=0; j<sz; j++){
            if(coins[j] > amount) break;
            if(coins[j] >= last) cnt += solve(coins, sz, amount-coins[j], last > coins[j] ? last : coins[j]);
        } 
        // System.out.println("For " + amount + " : " + cnt);

        return dp[amount][last] = cnt;
    }
}