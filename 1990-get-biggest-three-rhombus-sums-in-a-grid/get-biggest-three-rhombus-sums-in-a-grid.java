class Solution {
    private TreeSet<Integer> pq = new TreeSet<>((a, b) -> b - a);
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int a = -1, b = -1, c = -1;

        solve(grid, m, n, 0, 0);

        // System.out.println(pq);

        a = pq.pollFirst();
        if(!pq.isEmpty()) b = pq.pollFirst();
        else return new int[]{ a }; 
        if(!pq.isEmpty()) c = pq.pollFirst();
        else return new int[]{ a, b }; 

        return new int[]{ a, b, c };
    }

    private void solve(int grid[][], int m, int n, int r, int c) {
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                calc(grid, m, n, i, j);
            }
        }

    }
    private void calc(int grid[][], int m, int n, int r, int c){
        int cnt = 0, c1 = c, c2 = c;
        int tmp1, tmp2, tmpSum, tmpI;

        for(int i=r; i<m; i++){
            if(c1 < 0 || c2 >= n) break;
            else if(c1 == c2){
                cnt = grid[i][c1];
                pq.add(cnt);
            }
            else if(c1 != c2) {
                cnt += grid[i][c1] + grid[i][c2];
            }
            tmp1 = c1+1; tmp2 = c2-1; tmpSum = 0; tmpI = i+1;
            // System.out.println("Row and col " + r + " : " + c);
            // System.out.println("tmp1 and tmp2 " + tmp1 + ": " + tmp2);
            while(tmp1 <= c && tmp2 >= c && tmpI < m){
                tmpSum += grid[tmpI][tmp1] + grid[tmpI][tmp2];
                // System.out.println(tmp1 + " " + tmp2 + " <> " + tmpI + " " + tmpSum);
                if(tmp1 == tmp2){
                    tmpSum -= grid[tmpI][tmp1];
                    break;
                }
                tmp1++; tmp2--; tmpI++;
            }
            // System.out.println(cnt + " " + tmpSum);
            if(tmp1 == tmp2 && tmpI < m) pq.add(cnt + tmpSum);
            c1--; c2++;
        }

    }
}