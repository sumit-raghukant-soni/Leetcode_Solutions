class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, cnt = 0;
        int arr[][] = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = grid[i][j];
                if(i-1 >= 0) arr[i][j] += arr[i-1][j];
                if(j-1 >= 0) arr[i][j] += arr[i][j-1];
                if(i-1 >= 0 && j-1 >= 0) arr[i][j] -= arr[i-1][j-1];
                // System.out.print(arr[i][j] + ",");
                if(arr[i][j] <= k){
                    cnt++;
                }
            }
            // System.out.println();
        }

        return cnt;
    }
}