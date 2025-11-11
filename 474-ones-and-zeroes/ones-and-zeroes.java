class Solution {
    int ones[] = null, zeros[] = null;
    int dp[][][] = null;
    public int findMaxForm(String[] strs, int m, int n) {
        int sz = strs.length;
        // PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>();
        ones = new int[sz];
        zeros = new int[sz];
        dp = new int[sz][101][101];
        for(int i=0; i<sz; i++){
            for(int j=0; j<101; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        for(int i=0; i<sz; i++){
            int one = 0, zero = 0;
            for(int j=0; j<strs[i].length(); j++){
                char ch = strs[i].charAt(j);
                if(ch == '1') one++;
                else zero++;
            }
            ones[i] = one;
            zeros[i] = zero;
            // System.out.println(one + ":" + zero);
        }

        return solve(0, sz, m, n);
    }

    private int solve(int i, int sz, int m, int n){
        if(i >= sz) return 0;
        if(dp[i][m][n] != -1) return dp[i][m][n];

        int take = 0, notTake = solve(i+1, sz, m, n);
        if(n >= ones[i] && m >= zeros[i]){
            take = 1 + solve(i+1, sz, m - zeros[i], n - ones[i]);
        }

        return dp[i][m][n] = take > notTake ? take : notTake;
    }
}
