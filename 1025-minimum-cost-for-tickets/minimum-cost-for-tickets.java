class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int sz = days.length;
        int dp[] = new int[sz];

        for(int i=0; i<sz; i++){
            dp[i] = -1;
        }

        return solve(dp, days, days.length, costs, 0);
    }

    private int solve(int[] dp, int[] days, int sz, int[] costs, int i){
        if(i == sz) return 0;
        if(dp[i] != -1) return dp[i];

        int opt1 = costs[0] + solve(dp, days, sz, costs, i+1), opt2 = Integer.MAX_VALUE, opt3 = Integer.MAX_VALUE;
        int j=i+1;
        for(; j<sz && days[j]<days[i]+7; j++);
        opt2 = costs[1] + solve(dp, days, sz, costs, j);
        j = i+1;
        for(; j<sz && days[j]<days[i]+30; j++);
        opt3 = costs[2] + solve(dp, days, sz, costs, j);

        // System.out.println(i + " " + opt1 + " " + opt2 + " " + opt3);

        return dp[i] = Math.min(Math.min(opt1, opt2), opt3);
    }
}