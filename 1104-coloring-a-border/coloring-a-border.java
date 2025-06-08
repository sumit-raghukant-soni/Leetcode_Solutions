class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length, keyColor = grid[row][col];   
        int dr[] = {0, -1, 0, 1}, dc[] = {-1, 0, 1, 0};
        int vis[][] = new int[m][n], ans[][] = new int[m][n];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = 1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans[i][j] = grid[i][j];
            }
        }
        
        while(!q.isEmpty()){
            int i = q.peek().getKey(), j = q.peek().getValue(), cnt = 0;
            q.poll();

            for(int k=0; k<4; k++){
                int newi = i + dr[k], newj = j + dc[k];
                if(newi < m && newi >= 0 && newj < n && newj >= 0 && grid[newi][newj] == keyColor){
                    if(vis[newi][newj] == 0){
                        vis[newi][newj] = 1;
                        q.add(new Pair(newi, newj));
                    }
                    cnt++;
                }
            }

            if(cnt != 4) ans[i][j] = color;
        }

        return ans;
    }
}