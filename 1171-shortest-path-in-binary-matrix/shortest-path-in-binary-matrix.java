class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int vis[][] = new int[n][n];
        int dr[] = {0, 1, 0, -1, 1, -1, 1, -1}, dc[] = {1, 0, -1, 0, -1, 1, 1, -1,};
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        Integer[] tmp = {1, 0, 0};
        pq.add(tmp);
        vis[0][0] = 1;

        while(!pq.isEmpty()){
            tmp = pq.poll();
            int len = tmp[0], i = tmp[1], j = tmp[2];
            // System.out.println(len + " " + i + ":" + j);
            if(i == n-1 && j == n-1) return len;
            // vis[i][j] = 1;

            for(int k=0; k<8; k++){
                // System.out.println(dr[k] + ":" + dc[k]);
                int newi = dr[k] + i, newj = dc[k] + j;
                if(newi >= 0 && newi < n && newj >= 0 && newj < n && grid[newi][newj] == 0 && vis[newi][newj] == 0){
                    vis[newi][newj] = 1;
                    tmp = new Integer[3];
                    tmp[0] = len + 1;
                    tmp[1] = newi;
                    tmp[2] = newj;
                    pq.add(tmp);
                }
            }
        }

        return -1;
    }
}