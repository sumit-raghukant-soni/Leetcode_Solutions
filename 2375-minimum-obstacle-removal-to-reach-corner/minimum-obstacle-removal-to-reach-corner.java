class Solution {
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<Pair<Integer, Pair<Integer, Integer> > > q = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.getKey(), p2.getKey()));

        q.add(new Pair(0, new Pair(0, 0)));
        int ans = Integer.MAX_VALUE, row = grid.length, col = grid[0].length;
        int dr[] = {1, 0, -1, 0}, dc[] = {0, -1, 0, 1};
        HashMap<Pair<Integer, Integer>, Integer> mp = new HashMap<>();

        while(!q.isEmpty()){
            int cost = q.peek().getKey(), i = q.peek().getValue().getKey(), j = q.peek().getValue().getValue();
            q.poll();
            if(mp.containsKey(new Pair(i, j))) continue;

            mp.put(new Pair(i, j), 1);
            if(grid[i][j] == 1) cost++;

            if(i == row-1 && j == col-1){
                ans = Math.min(ans, cost);
                continue;
            }

            for(int k=0; k<4; k++){
                int nr = i + dr[k], nc = j + dc[k];
                if(nr >=0 && nr < row && nc >= 0 && nc < col){
                    q.add(new Pair(cost, new Pair(nr, nc)));
                }
            }
        }

        return ans;
    }
}