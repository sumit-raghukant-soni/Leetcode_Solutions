class Solution {
    int vis[][] = null, m, n;
    public int getMaximumGold(int[][] grid) {
        m = grid.length; n = grid[0].length;
        int tmp;
        vis = new int[m][n];
        int ans = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] > 0 && vis[i][j] == 0){
                    tmp = solve(grid, i, j);
                    ans = ans > tmp ? ans : tmp;
                }
            }
        }

        return ans;
    }


    private int solve(int[][] grid, int i, int j){
        int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0}, gold = 0, ans = 0;
        
        vis[i][j] = 1;
        for(int k=0; k<4; k++){
            int newi = dr[k] + i, newj = dc[k] + j;
            if(newi >= 0 && newj >= 0 && newi < m && newj < n && vis[newi][newj] == 0 && grid[newi][newj] > 0){
                gold = solve(grid, newi, newj);
                ans = ans > gold ? ans : gold;
            }
        }
        vis[i][j] = 0;
        
        return grid[i][j] + ans;
    }
}