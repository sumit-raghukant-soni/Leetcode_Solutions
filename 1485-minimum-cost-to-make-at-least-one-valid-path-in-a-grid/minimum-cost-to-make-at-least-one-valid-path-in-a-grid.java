class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        pq.add(new Pair(0, new Pair(0, 0)));
        Map<Pair<Integer, Integer>, Integer> mp = new HashMap<>();

        int dr[] = {0, 0, 1, -1}, dc[] = {1, -1, 0, 0};
        while(!pq.isEmpty()){
            int cost = pq.peek().getKey();
            Pair<Integer, Integer> curr = pq.peek().getValue();
            int i = curr.getKey(), j = curr.getValue();
            pq.poll();
            mp.put(curr, cost);
            // System.out.println(i + ":" + j + " = " + cost + ", " + prei + ":" + prej);
            if(i == m-1 && j == n-1) return cost;

            for(int k=0; k<4; k++){ 
                int newi = i + dr[k], newj = j + dc[k];
                Pair<Integer, Integer> newcurr = new Pair(newi, newj);
                if(newi < m && newi >=0 && newj < n && newj >= 0){
                    // System.out.println(newi + ":" + newj + " " + mp.containsKey(newcurr));
                    if(grid[i][j] == (k+1) && (!mp.containsKey(newcurr) || mp.get(newcurr) > cost)) {
                        mp.put(newcurr, cost);
                        pq.add(new Pair(cost, newcurr));
                    }
                    else if(!mp.containsKey(newcurr) || mp.get(newcurr) > (cost+1)){
                        mp.put(newcurr, cost+1);
                        pq.add(new Pair(cost+1, newcurr));
                    }
                }
            }
        }

        return -1;
    }
}