class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        int arrX[][] = new int[m][n], arrY[][] = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] =='X') arrX[i][j]++;
                if(i-1 >= 0) arrX[i][j] += arrX[i-1][j];
                if(j-1 >= 0) arrX[i][j] += arrX[i][j-1];
                if(i-1 >= 0 && j-1 >= 0) arrX[i][j] -= arrX[i-1][j-1];

                if(grid[i][j] =='Y') arrY[i][j]++;
                if(i-1 >= 0) arrY[i][j] += arrY[i-1][j];
                if(j-1 >= 0) arrY[i][j] += arrY[i][j-1];
                if(i-1 >= 0 && j-1 >= 0) arrY[i][j] -= arrY[i-1][j-1];
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arrX[i][j] == arrY[i][j] && arrX[i][j] > 0){
                    ans++;
                }
            }
        }

        return ans;
    }
}