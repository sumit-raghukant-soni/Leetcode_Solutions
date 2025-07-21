class Solution {
    private int[][] vis = null;
    private boolean flg = false;
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        vis = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0 && vis[i][j] == 0){
                    flg = true;
                    solve(grid, m, n, i, j);
                    // System.out.println(i + ":" + j + " "  + flg);
                    // for(int k=0; k<m; k++){
                    //     for(int k2=0; k2<n; k2++){
                    //         System.out.print(vis[k][k2] + ",");
                    //     }
                    //     System.out.println();
                    // }
                    if(flg) ans++;
                }
            }
        }

        return ans;
    }

    private void solve(int grid[][], int m, int n, int i, int j){
        int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        vis[i][j] = 1;
        q.add(new Pair(i, j));
        while(!q.isEmpty()){
            int x = q.peek().getKey(), y = q.peek().getValue();
            q.poll();
            
            if(grid[x][y] == 1) continue;
            for(int k=0; k<4; k++){
                int newx = dr[k] + x, newy = dc[k] + y;
                if(newx < m && newx >= 0 && newy < n && newy >= 0){
                    if(vis[newx][newy] == 0 && grid[newx][newy] == 0){
                        // System.out.println(newx + ":" + newy);
                        vis[newx][newy] = 1;
                        q.add(new Pair(newx, newy));
                    }
                }
                else{
                    flg = false;
                    // return;
                }
            }
        }
    }
}