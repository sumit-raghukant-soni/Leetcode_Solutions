class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int miniI = Integer.MAX_VALUE, miniJ = Integer.MAX_VALUE, maxiI = -1, maxiJ = -1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    miniI = i < miniI ? i : miniI;
                    miniJ = j < miniJ ? j : miniJ;
                    maxiI = i > maxiI ? i : maxiI;
                    maxiJ = j > maxiJ ? j : maxiJ;
                }
            }
        } 

        if(miniI == Integer.MAX_VALUE) return 0;

        return (maxiJ - miniJ + 1) * (maxiI - miniI + 1);
    }
}