class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long total = 0, curr;
        long rows[] = new long[m], cols[] = new long[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
                total += grid[i][j];
            }
        }
        
        curr = 0;
        for(int i=0; i<m; i++){
            curr += rows[i];
            if((curr*2) == total) return true;;
        }

        curr = 0;
        for(int i=0; i<n; i++){
            curr += cols[i];
            if((curr*2) == total) return true;;
        }

        return false;
    }
}