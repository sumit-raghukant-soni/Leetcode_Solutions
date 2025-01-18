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
            // System.out.println(i + ":" + j + " = " + cost);
            if(i == m-1 && j == n-1) return cost;

            for(int k=0; k<4; k++){ 
                int newi = i + dr[k], newj = j + dc[k], newcost = (grid[i][j] == (k+1) ? cost : cost+1);
                Pair<Integer, Integer> newcurr = new Pair(newi, newj);
                if(newi < m && newi >=0 && newj < n && newj >= 0 && (!mp.containsKey(newcurr) || mp.get(newcurr) > newcost)){
                    // System.out.println(newi + ":" + newj + " " + mp.containsKey(newcurr));
                    mp.put(newcurr, newcost);
                    pq.add(new Pair(newcost, newcurr));
                }
            }
        }

        return -1;
    }
}