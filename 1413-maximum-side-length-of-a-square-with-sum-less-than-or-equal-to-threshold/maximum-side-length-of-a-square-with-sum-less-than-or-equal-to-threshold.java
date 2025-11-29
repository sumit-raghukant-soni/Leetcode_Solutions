class Solution {
    public int maxSideLength(int[][] mat, int thres) {
        int m = mat.length, n = mat[0].length;
        int ans = 0, arr[][] = new int[m][n];

        for(int i=0; i<m; i++){
            int tmp = 0;
            for(int j=0; j<n; j++){
                arr[i][j] = mat[i][j];
                if(i-1 >= 0) arr[i][j] += arr[i-1][j];
                if(j-1 >= 0) arr[i][j] += arr[i][j-1];
                if(i-1 >= 0 && j-1 >= 0) arr[i][j] -= arr[i-1][j-1];
                int k1 = i, k2 = j, sum = 0;
                while(k1 >= 0 && k2 >= 0){
                    sum = arr[i][j];
                    if(k1 > 0) sum -= arr[k1-1][j];
                    if(k2 > 0) sum -= arr[i][k2-1];
                    if(k1 > 0 && k2 > 0) sum += arr[k1-1][k2-1];
                    // System.out.println(i + ":" + j + " <> " + k1 + ":" + k2 + " " + sum);
                    if(sum <= thres){
                        // System.out.println(i + ":" + j + " <> " + k1 + ":" + k2 + " " + (i-k1+1) + " sum " + sum);
                        ans = ans > (i-k1+1) ? ans : (i-k1+1);
                    }
                    k1--; k2--;
                }
            }
        }

        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(arr[i][j] + ",");
        //     }
        //     System.out.println();
        // }

        return ans;
    }
}