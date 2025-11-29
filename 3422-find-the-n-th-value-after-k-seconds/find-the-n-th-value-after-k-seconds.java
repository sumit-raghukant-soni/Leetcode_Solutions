class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int arr[][] = new int[k+1][n];
        int MOD = 1000_000_007;
        Arrays.fill(arr[0], 1);

        for(int i=1; i<=k; i++){
            arr[i][0] = 1;
            for(int j=1; j<n; j++){
                arr[i][j] = (arr[i][j-1] + arr[i-1][j])%MOD;
            }
        }

        // for(int i=0; i<=k; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(arr[i][j] + ",");
        //     }
        //     System.out.println();
        // }

        return arr[k][n-1];
    }
}