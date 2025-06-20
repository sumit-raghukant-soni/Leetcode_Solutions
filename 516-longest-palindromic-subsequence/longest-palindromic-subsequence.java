class Solution {
    public int longestPalindromeSubseq(String s) {
        int sz = s.length();
        int dp[][] = new int[sz][sz];
        StringBuilder tmp = new StringBuilder(s);
        tmp.reverse();
        String rev = tmp.toString();
        

        for(int i=0; i<sz; i++){
            for(int j=0; j<sz; j++){
                if(s.charAt(i) == rev.charAt(j)){
                    dp[i][j]++;
                    if(i-1 >= 0 && j-1 >= 0) dp[i][j] += dp[i-1][j-1];
                }
                else{
                    if(i-1 >= 0) dp[i][j] = dp[i-1][j];
                    if(j-1 >= 0) dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                }
            }
        }

        return dp[sz-1][sz-1];
    }

    private int solve(String s, int i, int j){
        if(i == j && s.charAt(i) == s.charAt(j)) return 1;
        if(i > j) return 0;
        int tmp = 0, ans = 0;

        for(; i<=j; i++){
            for(int k=j; k>=i; k--){
                if(s.charAt(i) == s.charAt(k)){
                    tmp = solve(s, i+1, k-1);
                    ans = Math.max(ans, tmp+2);
                }
            }
        }

        return ans;
    }
}