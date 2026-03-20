class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int ans[][] = new int[m-k+1][n-k+1];

        for(int i=0; i<m-k+1; i++){
            for(int j=0; j<n-k+1; j++){
                ans[i][j] = solve(grid, i, j, k);
                if(ans[i][j] == Integer.MAX_VALUE) ans[i][j] = 0;
            }
        }

        return ans;
    }

    private int solve(int[][] grid, int i, int j, int k){
        int ans = Integer.MAX_VALUE;
        int values[] = new int[k*k];

        for(int r=i; r<i+k; r++){
            for(int c=j; c<j+k; c++){
                // System.out.print(grid[r][c] + " at " + r + ":" + c + " " + k);
                values[((r-i)*k)+(c-j)] = grid[r][c];
            }
        }

        Arrays.sort(values);

        k = k*k;
        for(int r=0; r<k-1; r++){
            // System.out.print(values[r]);
            if(values[r+1] == values[r]) continue;
            ans = ans < (values[r+1] - values[r]) ? ans : (values[r+1] - values[r]);
        }
        // System.out.print(values[k-1]);
        // System.out.println();

        return ans;
    }
}