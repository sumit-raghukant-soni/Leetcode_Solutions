class Solution {
    private int dp[] = null;
    public int maxJumps(int[] arr, int d) {
        int sz = arr.length;
        int ans = 0;

        dp = new int[sz];
        Arrays.fill(dp, -1);

        for(int i=0; i<sz; i++){
            int cnt = solve(arr, sz, d, i);
            // System.out.println("for " + i + " " + cnt);
            ans = Math.max(ans, cnt);
        }

        return ans + 1;
    }

    private int solve(int[] arr, int sz, int d, int i) {
        if(dp[i] != -1) return dp[i];

        int cnt = 0, s = Math.max(i-d, 0), e = Math.min(i+d, sz-1);
        for(int j=i-1; j>=s; j--){
            if(arr[j] >= arr[i]) break;
            cnt = Math.max(cnt, 1 + solve(arr, sz, d, j));
        }
        for(int j=i+1; j<=e; j++){
            if(arr[j] >= arr[i]) break;
            cnt = Math.max(cnt, 1 + solve(arr, sz, d, j));
        }

        return dp[i] = cnt;
    }
}