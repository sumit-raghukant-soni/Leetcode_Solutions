class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
        int vis[][] = new int[m][n];
        PriorityQueue< Integer[] > pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int i=0; i<m; i++){
            Arrays.fill(vis[i], -1);
        }

        Integer[] tmp = new Integer[3];
        tmp[0] = 0; tmp[1] = 0; tmp[2] = 0;
        pq.add( tmp );

        int totalCost, currCost, i, j, nextCost, newi, newj;
        while(!pq.isEmpty()){
            tmp = pq.poll();
            totalCost = tmp[0] < 0 ? tmp[0]*-1 : tmp[0]; currCost = tmp[0] < 0 ? 2 : 1;
            i = tmp[1]; j = tmp[2];
            nextCost = currCost == 1 ? 2 : 1;

            if(i == m-1 && j == n-1) return totalCost;
            if(vis[i][j] != -1 && vis[i][j] <= totalCost) continue;
            vis[i][j] = totalCost;
            totalCost += currCost;
            for(int k=0; k<4; k++){
                newi = dr[k] + i; newj = dc[k] + j;
                if(newi < m && newi >= 0 && newj < n && newj >= 0){
                    tmp = new Integer[3];
                    if((moveTime[newi][newj] + currCost) > totalCost){
                        tmp[0] = (moveTime[newi][newj] + currCost);
                    }
                    else tmp[0] = totalCost;
                    tmp[1] = newi; tmp[2] = newj;
                    if(nextCost == 2) tmp[0] *= -1;
                    pq.add( tmp );
                }
            }
        }
        
        return -1;
    }
}