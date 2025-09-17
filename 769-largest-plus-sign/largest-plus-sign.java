class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int sz = mines.length, arr[][] = new int[n][n];
        int ans = 0, up[][] = new int[n][n], down[][] = new int[n][n], right[][] = new int[n][n], left[][] = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(arr[i], 1);
        }

        for(int i=0; i<sz; i++){
            int r = mines[i][0], c = mines[i][1];
            arr[r][c] = 0;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                up[j][i] = arr[j][i];
                up[j][i] += (j-1 >= 0 && arr[j-1][i] == 1) ? up[j-1][i] : 0;

                left[i][j] = arr[i][j];
                left[i][j] += (j-1 >= 0 && arr[i][j-1] == 1) ? left[i][j-1] : 0;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=n-1; j>=0; j--){
                if(arr[j][i] == 1){
                    down[j][i] = arr[j][i];
                    down[j][i] += (j+1 < n && arr[j+1][i] == 1) ? down[j+1][i] : 0;
                }

                if(arr[i][j] == 1){
                    right[i][j] = arr[i][j];
                    right[i][j] += (j+1 < n && arr[i][j+1] == 1) ? right[i][j+1] : 0;
                }
            }
        }

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(arr[i][j] + ",");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(right[i][j] + ",");
        //     }
        //     System.out.println();
        // }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // System.out.print(arr[i][j] + ",");
                int h = left[i][j] < right[i][j] ? left[i][j] : right[i][j];
                int v = up[i][j] < down[i][j] ? up[i][j] : down[i][j];

                // h *= 2;
                // v *= 2;
                // h--; v--;
                int sz2 = h > v ? v : h;
                // System.out.println(i + ":" + j + " " + left[i][j] + "<>" + right[i][j] + " and " + up[i][j] + "<>" + down[i][j]);
                ans = ans > sz2 ? ans : sz2;
            }
            // System.out.println();
        }

        return ans;
    }
}