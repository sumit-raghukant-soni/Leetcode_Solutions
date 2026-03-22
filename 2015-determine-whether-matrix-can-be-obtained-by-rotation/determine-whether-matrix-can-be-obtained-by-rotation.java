class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int arr[][] = new int[n][n];
        boolean flg = true;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = mat[i][j];
            }
        }

        for(int k=0; k<4; k++){
            flg = true;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = mat[(n-1) - j][i];
                    // System.out.print(arr[i][j] + ",");
                    if(arr[i][j] != target[i][j]) {
                        flg = false;
                    }
                }
                // System.out.println();
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    mat[i][j] = arr[i][j];
                }
            }
            if(flg) return true;
        }

        return flg;
    }
}