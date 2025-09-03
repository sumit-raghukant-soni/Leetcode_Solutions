class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long ans = 0;
        int up[][] = new int[m][n], down[][] = new int[m][n], left[][] = new int[m][n], right[][] = new int[m][n];

        for(int i=0; i<m; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                left[i][j] = cnt;
                if(grid[i][j] == 1) cnt++;
            }
        }

        for(int i=0; i<m; i++){
            int cnt = 0;
            for(int j=n-1; j>=0; j--){
                right[i][j] = cnt;
                if(grid[i][j] == 1) cnt++;
            }
        }

        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=m-1; j>=0; j--){
                down[j][i] = cnt;
                if(grid[j][i] == 1) cnt++;
            }
        }

        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<m; j++){
                up[j][i] = cnt;
                if(grid[j][i] == 1) cnt++;
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