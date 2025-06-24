class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        int dr[][] = new int[m][n], dc[][] = new int[m][n];

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(grid[i][j] == 1){
                    dr[i][j]++; dc[i][j]++;
                    if(i+1 < m) dr[i][j] += dr[i+1][j];
                    if(j+1 < n) dc[i][j] += dc[i][j+1];
                }
            }
        }

        // System.out.println("DR");
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(dr[i][j] + ",");
        //     }
        //     System.out.println();
        // }

        // System.out.println("DC");
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(dc[i][j] + ",");
        //     }
        //     System.out.println();
        // }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0) continue;
                ans = Math.max(ans, 1);
                // System.out.println("Start " + i + ":" + j);
                for(int k=1; k<=i && k<=j; k++){
                    if(dr[i-k][j] >= k+1 && dc[i][j-k] >= k+1 && dr[i-k][j-k] >= k+1 && dc[i-k][j-k] >= k+1){
                    // System.out.println("row " + (i-k) + ":" + j + " col " + i + ":" + (j-k));
                        ans = Math.max(ans, (k+1) * (k+1));
                    }
                }
            }
        }

        return ans;
    }
}