class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int arr[] = new int[n];
        int MOD = 1000_000_007;
        Arrays.fill(arr, 1);

        for(int i=1; i<=k; i++){
            for(int j=1; j<n; j++){
                arr[j] = (arr[j-1] + arr[j])%MOD;
            }
        }

        // for(int i=0; i<=k; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(arr[i][j] + ",");
        //     }
        //     System.out.println();
        // }

        return arr[n-1];
    }
}