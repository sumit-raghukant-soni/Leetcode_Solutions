class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length, MOD = 1_000_000_007;
        long vis[][] = new long[m][n];
        int down[][] = new int[m][n], right[][] = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                right[i][j] = find(grid, m, n, i, j+1, 0);
                down[i][j] = find(grid, m, n, i+1, j, 1);
            }
        }

        vis[0][0] = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) continue;
                if(down[i][j] != -1) {
                    int r = down[i][j] / 1000;
                    int c = down[i][j] % 1000;
                    vis[r][c] = (vis[r][c] + vis[i][j]) % MOD;
                }
                if(right[i][j] != -1) {
                    int r = right[i][j] / 1000;
                    int c = right[i][j] % 1000;
                    vis[r][c] = (vis[r][c] + vis[i][j]) % MOD;
                }
            }
        }

        return (int) vis[m-1][n-1];
    }

    private int find(int[][] grid, int m, int n, int i, int j, int dir) {
        if(i >= m || j >= n) return -1;
        if(grid[i][j] == 0) return (i * 1000) + j;

        if(dir == 0) return find(grid, m, n, i+1, j, 1);
        else return find(grid, m, n, i, j+1, 0);
    }
}


// 0 1 0
// 0 0 1
// 1 0 0