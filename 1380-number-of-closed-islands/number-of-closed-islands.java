class Solution {
    private int m, n, vis[][] = null;
    private int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
    public int closedIsland(int[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        vis = new int[m][n];

        for(int i=0; i<m; i++) {
            if(vis[i][0] == 0 && grid[i][0] == 0) {
                solve(grid, i, 0);
            }
            if(vis[i][n-1] == 0 && grid[i][n-1] == 0) {
                solve(grid, i, n-1);
            }
        }

        for(int i=0; i<n; i++) {
            if(vis[0][i] == 0 && grid[0][i] == 0) {
                solve(grid, 0, i);
            }
            if(vis[m-1][i] == 0 && grid[m-1][i] == 0) {
                solve(grid, m-1, i);
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 0) {
                    ans++;
                    solve(grid, i, j);
                    // System.out.println();
                }
            }
        }


        return ans;
    }

    private void solve(int[][] grid, int i, int j) {
        vis[i][j] = 1;
        // System.out.println(i + ":" + j + ",");
        for(int k=0; k<4; k++) {
            int newi = i + dr[k], newj = j + dc[k];
            if(newi >= 1 && newj >= 1 && 
            newi < m-1 && newj < n-1 && 
            grid[newi][newj] == 0 && vis[newi][newj] == 0) {
                solve(grid, newi, newj);
            }
        }
    }
}

// [1,1,1,1,1,1,1,0],
// [1,0,0,0,0,1,1,0],
// [1,0,1,0,1,1,1,0],
// [1,0,0,0,0,1,0,1],
// [1,1,1,1,1,1,1,0]]