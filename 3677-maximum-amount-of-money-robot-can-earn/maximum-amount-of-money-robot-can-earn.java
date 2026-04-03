class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int ans = Integer.MIN_VALUE, DEFAULT_VALUE = Integer.MIN_VALUE/2;
        int arr[][][] = new int[m][n][3];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<3; k++){
                    arr[i][j][k] = DEFAULT_VALUE;
                }
            }
        }

        arr[0][0][0] = coins[0][0];
        if(coins[0][0] < 0){
            arr[0][0][1] = 0;
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0) continue;

                for(int k=0; k<3; k++){
                    int bestPrev = DEFAULT_VALUE;

                    if(i > 0){
                        bestPrev = Math.max(bestPrev, arr[i-1][j][k]);
                    }

                    if(j > 0){
                        bestPrev = Math.max(bestPrev, arr[i][j-1][k]);
                    }

                    if(bestPrev != DEFAULT_VALUE) {
                        arr[i][j][k] = Math.max(arr[i][j][k], bestPrev + coins[i][j]);
                    }

                    if(coins[i][j] < 0 && k > 0){
                        int bestPrevWithout1 = DEFAULT_VALUE;

                        if(i > 0){
                            bestPrevWithout1 = Math.max(bestPrevWithout1, arr[i-1][j][k-1]);
                        }

                        if(j > 0){
                            bestPrevWithout1 = Math.max(bestPrevWithout1, arr[i][j-1][k-1]);
                        }
                        arr[i][j][k] = Math.max(arr[i][j][k], bestPrevWithout1);
                    }
                }
            }
        }

        for(int k=0; k<3; k++){
            ans = Math.max(ans, arr[m-1][n-1][k]);
        }

        return ans;
    }
}