class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int dp[][] = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j]++;
                    if(i-1 >= 0 && j-1 >= 0) dp[i][j] += dp[i-1][j-1];
                }
                else{
                    if(i-1 >= 0) dp[i][j] = dp[i-1][j];
                    if(j-1 >= 0) dp[i][j] = dp[i][j] > dp[i][j-1] ? dp[i][j] : dp[i][j-1];
                }
            }
        }

        return (m+n) - (2*dp[m-1][n-1]);
    }
}