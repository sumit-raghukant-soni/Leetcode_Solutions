class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int sz = queries.length;
        int arr[][] = new int[n][n], flg[][] = new int[n][n];

        for(int i=0; i<sz; i++){
            int r1 = queries[i][0], r2 = queries[i][2];
            int c1 = queries[i][1], c2 = queries[i][3];
            flg[r1][c1] += 1;
            if(r2+1 < n && c2+1 < n) flg[r2+1][c2+1] += 1;
            if(r2+1 < n) flg[r2+1][c1] -= 1;
            if(c2+1 < n) flg[r1][c2+1] -= 1;
        }

        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(i+1 < n) flg[i+1][j] += flg[i][j];
                cnt += flg[i][j];
                // System.out.println(i + ":" + j + " = " + cnt);
                arr[i][j] = cnt;
            }
        }

        return arr;
    }
}