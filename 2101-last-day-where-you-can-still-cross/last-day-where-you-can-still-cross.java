class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int sz = cells.length, s = 0, e = sz-1;
        int ans = -1;
        
        while(s <= e){
            int mid = (e+s+1)/2;
            // System.out.println(s + " " + mid + " " + e);
            if(isValid(row, col, cells, mid)){
                // System.out.println(ans);
                ans = mid;
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }

        return ans;
    }

    private boolean isValid(int m, int n, int[][] cells, int ind){
        // System.out.println(ind + " " + m + " " + n);
        int arr[][] = new int[m][n];
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        Set<Pair<Integer, Integer>> vis = new HashSet<>();

        for(int i=0; i<ind; i++){
            // System.out.println((cells[i][0]-1) + " " + (cells[i][1]-1));
            arr[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        // if(ind == 35){
        //     for(int i=0; i<m; i++){
        //         for(int j=0; j<n; j++){
        //             System.out.print(arr[i][j] + ",");
        //         }
        //         System.out.println();
        //     }
        // }

        for(int i=0; i<n; i++){
            if(arr[0][i] == 0) pq.add(new Pair(0, i));
        }

        while(!pq.isEmpty()){
            Pair<Integer, Integer> curr = pq.poll();
            if(vis.contains(curr)) continue;
            vis.add(curr);
            int r = curr.getKey(), c = curr.getValue();
            if(r == m-1) return true;
            if(r > 0 && arr[r-1][c] == 0) pq.add(new Pair(r-1, c));
            if(r < m-1 && arr[r+1][c] == 0) pq.add(new Pair(r+1, c));
            if(c > 0 && arr[r][c-1] == 0) pq.add(new Pair(r, c-1));
            if(c < n-1 && arr[r][c+1] == 0) pq.add(new Pair(r, c+1));
        }

        // System.out.println("False");
        return false;
    }
}