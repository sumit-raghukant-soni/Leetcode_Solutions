class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        int dr[] = {0, -1, 0, 1}, dc[] = {-1, 0, 1, 0};
        int vis[][] = new int[m][n];
        PriorityQueue< Integer[] > pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int i=0; i<m; i++){
            Arrays.fill(vis[i], -1);
        }

        Integer[] tmp = new Integer[4];
        tmp[0] = 0; tmp[1] = 1; tmp[2] = 0; tmp[3] = 0;
        pq.add( tmp );

        while(!pq.isEmpty()){
            tmp = pq.poll();
            int totalCost = tmp[0], currCost = tmp[1];
            int i = tmp[2], j = tmp[3];
            int nextCost = currCost == 1 ? 2 : 1;

            if(i == m-1 && j == n-1) return totalCost;
            if(vis[i][j] != -1 && vis[i][j] <= totalCost) continue;
            vis[i][j] = totalCost;

            for(int k=0; k<4; k++){
                int newi = dr[k] + i, newj = dc[k] + j;
                if(newi < m && newi >= 0 && newj < n && newj >= 0){
                    tmp = new Integer[4];
                    tmp[0] = Math.max(moveTime[newi][newj] + currCost, totalCost + currCost); 
                    tmp[1]= nextCost; tmp[2] = newi; tmp[3] = newj;
                    pq.add( tmp );
                }
            }
        }
        
        return -1;
    }
}