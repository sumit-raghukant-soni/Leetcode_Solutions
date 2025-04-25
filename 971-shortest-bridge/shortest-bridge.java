class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length, ans = Integer.MAX_VALUE;
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> q = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        int vis[][] = new int[n][n];
        int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(0, new Pair(i, j)));
                    break;
                }
            }
            if(!q.isEmpty()) break;
        }

        while(!q.isEmpty()){
            int val = q.peek().getKey();
            int r = q.peek().getValue().getKey(), c = q.peek().getValue().getValue();
            q.poll();
            // System.out.println(r + ":" + c + " " + val);
            if(grid[r][c] == 1 && val != 0) return val;
            if(vis[r][c] == 1) continue;
            vis[r][c] = 1;
            for(int i=0; i<4; i++){
                int newr = r + dr[i], newc = c + dc[i];
                if(newr < n && newc < n && newr >= 0 && newc >= 0 && vis[newr][newc] == 0){
                    if(grid[newr][newc] == 0) q.add(new Pair(val + 1, new Pair(newr, newc)));
                    else q.add(new Pair(val, new Pair(newr, newc)));
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}