class Solution {
    double dp[][] = null;
    public double soupServings(int n) {
        if(n > 5000) return 1;
        n =  (n%25 == 0 ? 0 : 1) + n/25;
        dp = new double[n+1][n+1];

        for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1.0);

        return solve(n, n);
    }

    private double solve(int a, int b){
        if(a <= 0 && b <= 0) return 0.5;
        if(a <= 0) return 1;
        if(b <= 0) return 0;
        if(dp[a][b] != -1) return dp[a][b];

        double op1 = a > 0 ? solve(a-4, b) : 0;
        double op2 = a > 0 && b > 0 ? solve(a-3, b-1) : 0;
        double op3 = a > 0 ? solve(a-2, b-2) : 0;
        double op4 = a > 0 ? solve(a-1, b-3) : 0;

        return dp[a][b] = 0.25 * (op1 + op2 + op3 + op4);
    }
}