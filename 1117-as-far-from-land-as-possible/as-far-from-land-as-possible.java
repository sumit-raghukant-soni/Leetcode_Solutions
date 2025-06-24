class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length, ans = -1;
        int vis[][] = new int[n][n], dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
        Integer[] tmp = null;
        Queue<Integer[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    tmp = new Integer[3];
                    tmp[0] = i;
                    tmp[1] = j;
                    tmp[2] = 0;
                    q.add(tmp);
                }
            }
        }

        while(!q.isEmpty()){
            tmp = q.poll();
            int i = tmp[0], j = tmp[1], dis = tmp[2];
            if(vis[i][j] != 0) continue;
            // System.out.println(i + ":" + j + " = " + dis);
            ans = ans > dis ? ans : dis;
            vis[i][j] = dis;
            
            for(int k=0; k<4; k++){
                int newi = i + dr[k], newj = j + dc[k];
                if(newi < n && newj < n && newi >= 0 && newj >= 0 && grid[newi][newj] == 0 && vis[newi][newj] == 0){
                    tmp = new Integer[3];
                    tmp[0] = newi;
                    tmp[1] = newj;
                    tmp[2] = dis+1;
                    q.add(tmp);
                }
            }
        }

        return ans == 0 ? -1 : ans;
    }
}