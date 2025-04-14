class Solution {
    public int findLUSlength(String a, String b) {
        int sz1 = a.length(), sz2 = b.length(), ans = 0;
        if(sz1 >= sz2 && !b.contains(a)) return sz1;
        if(sz2 >= sz1 && !a.contains(b)) return sz2;
        int[][] dp = new int[sz1][sz2];

        for(int i=0; i<sz1; i++){
            for(int j=0; j<sz2; j++){
                if(a.charAt(i) == b.charAt(j)){
                    dp[i][j]++;
                    if(i-1 >= 0 && j-1 >= 0) dp[i][j] += dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max((i-1 >= 0 ? dp[i-1][j] : 0), (j-1 >= 0 ? dp[i][j-1] : 0));
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        ans = Math.max(sz1, sz2) - ans;
        return ans == 0 ? -1 : ans;
    }
}