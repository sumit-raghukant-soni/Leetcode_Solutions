class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int dp[][] = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0) continue;
                int left = j-1 >= 0 ? dp[i][j-1] : 0, 
                up = i-1 >= 0 ? dp[i-1][j] : 0, 
                diag = (j-1 >= 0 && i-1 >= 0) ? dp[i-1][j-1] : 0;
                int cnt = Math.min(Math.min(diag, up), left);
                dp[i][j] = cnt + 1;
                ans += cnt + 1;
            }
        }

        return ans;
    }
}