class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        int dr[] = {0, -1, 0, 1}, dc[] = {-1, 0, 1, 0};
        int vis[][] = new int[m][n];
        PriorityQueue< Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> > pq = new PriorityQueue<>((a, b) -> a.getKey().getKey() - b.getKey().getKey());

        for(int i=0; i<m; i++){
            Arrays.fill(vis[i], -1);
        }

        pq.add( new Pair(new Pair(0, 1), new Pair(0, 0)) );

        while(!pq.isEmpty()){
            int totalCost = pq.peek().getKey().getKey(), currCost = pq.peek().getKey().getValue();
            int i = pq.peek().getValue().getKey(), j = pq.peek().getValue().getValue();
            int nextCost = currCost == 1 ? 2 : 1;
            pq.poll();

            // if(m == 2 && n == 3) System.out.println(i + " " + j + " = " + totalCost);

            if(i == m-1 && j == n-1) return totalCost;
            if(vis[i][j] != -1 && vis[i][j] <= totalCost) continue;
            vis[i][j] = totalCost;

            for(int k=0; k<4; k++){
                int newi = dr[k] + i, newj = dc[k] + j;
                if(newi < m && newi >= 0 && newj < n && newj >= 0){
                    pq.add( new Pair( new Pair(Math.max(moveTime[newi][newj] + currCost, totalCost + currCost) , nextCost), new Pair(newi, newj) ) );
                }
            }
        }
        
        return -1;
    }
}