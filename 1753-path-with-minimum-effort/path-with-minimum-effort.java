class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0}, arr[][] = new int[m][n];
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> {
            return a.get(2) - b.get(2);
        });

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.MAX_VALUE;
            }
        }

        pq.add(List.of(0, 0, 0));
        arr[0][0] = 0;
        while(!pq.isEmpty()){
            int currX = pq.peek().get(0), currY = pq.peek().get(1), currE = pq.peek().get(2);
            pq.poll();
            // System.out.println(currX + " " + currY + " " + currE);

            if(currX == m-1 && currY == n-1) return currE;

            for(int i=0; i<4; i++){
                int r = dr[i] + currX, c = dc[i] + currY;
                if(r >= 0 && r < m && c >= 0 && c < n){
                    int e = Math.max(Math.abs(heights[currX][currY] - heights[r][c]), currE);
                    if(e < arr[r][c]){
                        arr[r][c] = e;
                        pq.add(List.of(r, c, e));
                    }
                }
            }
        }

        return -1;
    }
}