class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int arr[][] = new int[m][n];
        int ans = 1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=i+1; k<m; k++){
                    if(isMagicSquare(grid, m, n, i, j, k-i+1)){
                        // System.out.println("true " + i + " " + j + " : " + k);
                        ans = ans > (k - i + 1) ? ans : (k - i + 1);
                    }
                }
            }
        }

        return ans;
    }

    private boolean isMagicSquare(int[][] grid, int m, int n, int i, int j, int k){
        if(i+k > m || j+k > n) return false;

        // System.out.println(i + " " + j + " : " + k);
        int rSum[] = new int[k], cSum[] = new int[k], d1 = 0, d2 = 0;

        for(int i2 = i; i2 < i+k; i2++){
            for(int j2 = j; j2 < j+k; j2++){
                rSum[i2-i] += grid[i2][j2];
                cSum[j2-j] += grid[i2][j2];
            }
        }

        for(int i2 = i, j2 = j; i2 < i+k; i2++){
            d1 += grid[i2][j2++];
        }

        for(int i2 = i, j2 = j+k-1; i2 < i+k; i2++){
            d2 += grid[i2][j2--];
        }

        int val = rSum[0];
        // System.out.println("d " + d1 + ":" + d2 + " " + val);
        for(int i2 : rSum){
            if(i2 != val) return false;
        }
        for(int i2 : cSum){
            if(i2 != val) return false;
        }

        return d1 == d2 && d1 == val;
    }
}