class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length, ans = -1;
        int vis[][] = new int[n][n], dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
        List<Integer> tmp = null;
        Queue<List<Integer>> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    tmp.add(0);
                    q.add(tmp);
                }
            }
        }

        while(!q.isEmpty()){
            tmp = q.poll();
            int i = tmp.get(0), j = tmp.get(1), dis = tmp.get(2);
            if(vis[i][j] != 0) continue;
            // System.out.println(i + ":" + j + " = " + dis);
            ans = Math.max(ans, dis);
            vis[i][j] = dis;
            
            for(int k=0; k<4; k++){
                int newi = i + dr[k], newj = j + dc[k];
                if(newi < n && newj < n && newi >= 0 && newj >= 0 && grid[newi][newj] == 0 && vis[newi][newj] == 0){
                    tmp = new ArrayList<>();
                    tmp.add(newi);
                    tmp.add(newj);
                    tmp.add(dis+1);
                    q.add(tmp);
                }
            }
        }

        return ans == 0 ? -1 : ans;
    }
}