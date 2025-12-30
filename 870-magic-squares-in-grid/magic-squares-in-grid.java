class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0, r[][] = new int[m][n], c[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) r[i][j] = r[i][j - 1];
                if (i > 0) c[i][j] = c[i - 1][j];
                r[i][j] += grid[i][j];
                c[i][j] += grid[i][j];
                if (j > 2) r[i][j] -= grid[i][j - 3];
                if (i > 2) c[i][j] -= grid[i - 3][j];

                if (i >= 2 && j >= 2 &&
                        r[i][j] == r[i - 1][j] && r[i][j] == r[i - 2][j] &&
                        c[i][j] == c[i][j - 1] && c[i][j] == c[i][j - 2] &&
                        r[i][j] == c[i][j] &&
                        checkDistinct(grid, i, j)) {
                    cnt++;
                }
            }

        }

        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(r[i][j] + ",");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(c[i][j] + ",");
        //     }
        //     System.out.println();
        // }

        return cnt;
    }

    private boolean checkDistinct(int grid[][], int r, int c) {
        int fq[] = new int[16];
        int v1 = 0, v2 = 0;

        for (int i = r - 2; i <= r; i++) {
            for (int j = c - 2; j <= c; j++) {
                if(r-i == c-j) v1 += grid[i][j];
                if((i - r + 2) + (j - c + 2) == 2) v2 += grid[i][j];
                if (fq[grid[i][j]] == 1
                        || grid[i][j] > 9 || grid[i][j] == 0
                        || grid[i][j] > 9 || grid[i][j] == 0)
                    return false;
                fq[grid[i][j]]++;
            }
        }
    
        // return true;
        return v1 == v2;
    }
}