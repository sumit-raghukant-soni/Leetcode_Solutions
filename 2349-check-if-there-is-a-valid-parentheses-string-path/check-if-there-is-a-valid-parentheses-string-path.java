class Solution {
    private int m, n;
    private int[][][] dp = null;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length; n = grid[0].length;
        dp = new int[m][n][500];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(grid, 0, 0, 0);
    }

    private boolean solve(char[][] grid, int i, int j, int cnt) {
        if(i == m || j == n) return false;

        if(grid[i][j] == '(') cnt++;
        else cnt--;

        if(i == m-1 && j == n-1) return cnt == 0;

        if(dp[i][j][cnt+200] != -1) return dp[i][j][cnt+200] == 1;

        if(cnt < 0) return false;

        boolean a = solve(grid, i+1, j, cnt);
        boolean b = solve(grid, i, j+1, cnt);

        dp[i][j][cnt+200] = (a || b ? 1 : 0);
        return a || b;
    }
}