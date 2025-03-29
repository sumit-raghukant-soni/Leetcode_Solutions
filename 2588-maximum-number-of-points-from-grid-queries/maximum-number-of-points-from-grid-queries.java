class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int sz = queries.length;
        int ans[] = new int[sz], dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
        int vis[][] = new int[m][n];
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> q = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        Map<Integer, Integer> mp = new TreeMap<>();

        for(int i=0; i<m; i++) Arrays.fill(vis[i], -1);
        vis[0][0] = 1;

        q.add(new Pair(grid[0][0]+1, new Pair(0, 0)));

        while(!q.isEmpty()){
            int curr = q.peek().getKey();
            int x = q.peek().getValue().getKey(), y = q.peek().getValue().getValue();
            q.poll();
            // System.out.println(curr + " " + x + ":" + y);
            mp.put(curr, mp.getOrDefault(curr, 0) + 1);
            for(int i=0; i<4; i++){
                int newx = x + dr[i], newy = y + dc[i];
                if(newx >= 0 && newy >= 0 && newx < m && newy < n && vis[newx][newy] == -1){
                    vis[newx][newy] = 1;
                    q.add(new Pair(Math.max(curr, grid[newx][newy]+1), new Pair(newx, newy)));
                }
            }
        }

        // System.out.println(mp);

        for(int i=0; i<sz; i++){
            int points = 0;
            for(Map.Entry<Integer, Integer> e : mp.entrySet()){
                if(e.getKey() > queries[i]) break;
                points += e.getValue();
            }
            ans[i] = points;
        }

        return ans;
    }
}