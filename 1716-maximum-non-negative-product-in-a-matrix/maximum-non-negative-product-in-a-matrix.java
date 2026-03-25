class Solution {
    long arr[][] = null;
    int MOD = 1_000_000_007;
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        arr = new long[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(arr[i], Integer.MIN_VALUE);
        }

        solve(grid, m, n, 0, 0, 1);

        return (arr[m-1][n-1] < 0L) ? -1 : (int) (arr[m-1][n-1] % MOD);
    }

    private void solve(int[][] grid, int m, int n, int i, int j, long val) {
        if(i == m || j == n) return;
        
        val *= grid[i][j];
        if(arr[i][j] > 0 && val > 0 && arr[i][j] >= val){
            return;
        }
        if(arr[i][j] != Integer.MIN_VALUE && arr[i][j] < 0 && val < 0 && arr[i][j] <= val){
            return;
        }
        if(arr[i][j] == val && val == 0) return;
        arr[i][j] = arr[i][j] > val ? arr[i][j] : val;
        if(i+1 < m) solve(grid, m, n, i+1, j, val);
        if(j+1 < n) solve(grid, m, n, i, j+1, val);
    }
}

// [-1,-4, 2],
// [ 4, 3,-1],
// [ 2,-4, 4],
// [ 1,-1,-4]