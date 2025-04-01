class Solution {
    private long[] dp;
    private int sz;
    public long mostPoints(int[][] questions) {
        sz = questions.length;
        long ans = 0;
        dp = new long[sz];
        Arrays.fill(dp, -1);
        
        ans = solve(questions, 0);

        return ans;
    }

    private long solve(int[][] questions, int i){
        if(i >= sz) return 0L;
        if(dp[i] != -1) return dp[i];
        // System.out.println(i + " " + sz);

        long a = solve(questions, i+1);
        long b = questions[i][0] + solve(questions, i+1+questions[i][1]);

        // System.out.println(i + " " + a + ":" + b);
        dp[i] = Math.max(a, b);
        return dp[i];
    }
}