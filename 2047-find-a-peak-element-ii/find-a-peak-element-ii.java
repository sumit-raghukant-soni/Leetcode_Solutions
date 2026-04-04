class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length, cnt;
        int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                cnt = 0;
                for(int k=0; k<4; k++){
                    int r = dr[k] + i, c = dc[k] + j;
                    if(r >= 0 && r < m && c >= 0 && c < n){
                        if(mat[r][c] < mat[i][j]) cnt++;
                    }
                    else cnt++;
                }
                if(cnt == 4) return new int[]{i, j};
            }
        }

        return new int[]{0,0};
    }
}