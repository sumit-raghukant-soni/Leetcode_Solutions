class Solution {
    private int m, n, vis[][][] = null;
    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new int[m][n][1024];

        solve(grid, 0, 0, 0);

        for(int i=0; i<1024; i++) {
            if(vis[m-1][n-1][i] != 0) return i;
        }

        return -1;
    }

    private void solve(int grid[][], int i, int j, int xor) {
        xor = xor ^ grid[i][j];
        vis[i][j][xor] = 1;

        if(i+1 < m) {
            int nXor = xor ^ grid[i+1][j];
            if(vis[i+1][j][nXor] == 0) solve(grid, i+1, j, xor);
        }
        if(j+1 < n) {
            int nXor = xor ^ grid[i][j+1];
            if(vis[i][j+1][nXor] == 0) solve(grid, i, j+1, xor);
        }

        return;
    }
}