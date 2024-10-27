class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length, ans = 0;
        int dp[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    int top = (i - 1 >= 0 ? dp[i - 1][j] : 0), left = (j - 1 >= 0 ? dp[i][j - 1] : 0),
                            diag = (i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0);
                    dp[i][j] = Math.min(top, Math.min(left, diag));
                    dp[i][j]++;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dp[i][j] != 0) {
                    if (i - 1 >= 0
                            && j - 1 >= 0
                            && dp[i - 1][j] > 0
                            && dp[i][j - 1] > 0
                            && dp[i - 1][j - 1] > 0) {
                        // System.out.println("this " + i + " " + j);
                        ans += Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    }
                    ans++;
                }

                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }

        return ans;
    }
}