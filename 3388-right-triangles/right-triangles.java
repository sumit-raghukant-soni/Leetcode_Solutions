class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long ans = 0;
        int up[][] = new int[m][n], down[][] = new int[m][n], left[][] = new int[m][n], right[][] = new int[m][n];

        for(int i1=0; i1<m; i1++){
            int cnt1 = 0, cnt2 = 0;
            for(int j1=0, j2 = n-1; j1<n; j1++, j2--){
                left[i1][j1] = cnt1;
                cnt1 += grid[i1][j1] == 1 ? 1 : 0;
                right[i1][j2] = cnt2;
                cnt2 += grid[i1][j2] == 1 ? 1 : 0;
            }
        }

        for(int i1=0; i1<n; i1++){
            int cnt1 = 0, cnt2 = 0;
            for(int j1=0, j2 = m-1; j1<m; j1++, j2--){
                up[j1][i1] = cnt1;
                cnt1 += grid[j1][i1] == 1 ? 1 : 0;
                down[j2][i1] = cnt2;
                cnt2 += grid[j2][i1] == 1 ? 1 : 0;
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    ans += left[i][j] * up[i][j];
                    ans += left[i][j] * down[i][j];
                    ans += right[i][j] * up[i][j];
                    ans += right[i][j] * down[i][j];
                }
            }
        }

        return ans;
    }
}