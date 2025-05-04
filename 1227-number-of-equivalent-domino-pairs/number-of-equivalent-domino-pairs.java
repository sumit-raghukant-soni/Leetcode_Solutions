class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int sz = dominoes.length, ans = 0;
        int dp[][] = new int[10][10];

        for(int i=0; i<sz; i++){
            int a = Math.min(dominoes[i][0], dominoes[i][1]);
            int b = Math.max(dominoes[i][0], dominoes[i][1]);
            dp[a][b]++;
        }

        for(int i=1; i<10; i++){
            for(int j=i; j<10; j++){
                if(dp[i][j] > 1){
                    ans += (dp[i][j] * (dp[i][j]-1)) / 2;
                }
            }
        }

        return ans;
    }
}