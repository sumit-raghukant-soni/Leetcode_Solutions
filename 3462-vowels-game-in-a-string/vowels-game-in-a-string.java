class Solution {
    private int dp[][] = null;
    public boolean doesAliceWin(String s) {
        int sz = s.length(), n = 0, ans = 0;

        for(int i=0; i<sz; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') n++;
        }

        dp = new int[n+1][2];
        for(int i=0; i<=n; i++){
            dp[i][0] = dp[i][1] = -1;
        }

        if(n == 0) return false;
        solve(n, 0);

        // for(int i=1; i<=n; i++){
        //     System.out.println(dp[i][0] + " " + dp[i][1]);
        // }

        // return solve(n, 1);
        // return a == 1;
        // System.out.println(n);
        return dp[n][0] == 1 ? true : false;
    }

    private int solve(int n, int i){
        if(n == 1) return dp[n][i] = 1;
        if(n == 0) return dp[n][i] = i == 0 ? 1 : 0;
        if(dp[n][i] != -1) return dp[n][i];

        boolean flg = false;
        for(int j= (i == 1 ? 2 : 1); j<=n; j+=2){
            // System.out.println(n + " " + (n-j) + " " + i);
            flg = solve(n-j, i == 1 ? 0 : 1) == 1;
            if(flg) break;
        }

        dp[n][i] = flg ? 1 : 0;
        return dp[n][i];
    }
}