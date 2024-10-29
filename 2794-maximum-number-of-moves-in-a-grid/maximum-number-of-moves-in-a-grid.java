class Solution {
    public int solve(int[][] grid, int[][] dp, int row, int col, int i, int j, int[] ans) {
        // System.out.println(i + " " + j);
        if (i == row || j == col)
            return 0;

        int top = 0, right = 0, bottom = 0;
        if (i - 1 >= 0 && j + 1 < col && grid[i][j] < grid[i - 1][j + 1]) {
            if (dp[i - 1][j + 1] == -1) top = solve(grid, dp, row, col, i - 1, j + 1, ans);
            else top = dp[i - 1][j + 1];
        }
        if (j + 1 < col && grid[i][j] < grid[i][j + 1]) {
            if (dp[i][j + 1] == -1) right = solve(grid, dp, row, col, i, j + 1, ans);
            else right = dp[i][j + 1];
        }
        if (i + 1 < row && j + 1 < col && grid[i][j] < grid[i + 1][j + 1]) {
            if (dp[i + 1][j + 1] == -1) bottom = solve(grid, dp, row, col, i + 1, j + 1, ans);
            else bottom = dp[i + 1][j + 1];
        }

        ans[0] = Math.max(ans[0], 1 + Math.max(top, Math.max(right, bottom)));

        return dp[i][j] = 1 + Math.max(top, Math.max(right, bottom));
    }

    public int maxMoves(int[][] grid) {
        int row = grid.length, col = grid[0].length, ans[] = new int[1], dp[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < row; i++) {
            if (dp[i][0] == -1 && ans[0] < col) {
                solve(grid, dp, row, col, i, 0, ans);
            }
        }

        return ans[0]-1;
    }
}