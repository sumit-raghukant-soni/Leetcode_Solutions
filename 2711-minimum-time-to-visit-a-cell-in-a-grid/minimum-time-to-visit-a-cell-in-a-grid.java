class Solution {
    public int minimumTime(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if(Math.abs(grid[0][0] - grid[0][1]) > 1 && Math.abs(grid[0][0] - grid[1][0]) > 1) return -1;
        int ans = Integer.MAX_VALUE;
        int dr[] = {0, -1, 0, 1}, dc[] = {1, 0, -1, 0};
        HashMap<Pair<Integer, Integer>, Integer> mp = new HashMap<>();
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> q = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.getKey(), p2.getKey()));
        q.add(new Pair(0, new Pair(0, 0)));

        while(!q.isEmpty()){
            int time = q.peek().getKey(), i = q.peek().getValue().getKey(), j = q.peek().getValue().getValue();
            q.poll();
            // System.out.println(i + ":" + j + " " + time);
            if(mp.containsKey(new Pair(i, j)) && mp.get(new Pair(i, j)) <= time) continue;
            mp.put(new Pair(i, j), time);
            if(i == row-1 && j == col-1){
                ans = Math.min(ans, time);
                break;
            }

            for(int k=0; k<4; k++){
                int nr = i + dr[k], nc = j + dc[k];
                if(nr >= 0 && nr < row && nc >= 0 && nc < col){
                    if(grid[nr][nc] <= (time+1)) q.add(new Pair(time+1, new Pair(nr, nc)));
                    else{
                        int diff = Math.abs(grid[nr][nc] - time);
                        q.add(new Pair(time + (diff) + ((diff&1) == 1 ? 0 : 1), new Pair(nr, nc)));
                    }
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}