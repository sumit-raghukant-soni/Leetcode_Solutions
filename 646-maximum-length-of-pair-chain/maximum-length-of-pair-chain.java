class Solution {
    public int findLongestChain(int[][] pairs) {
        int sz = pairs.length, ans = 0;
        int dp[] = new int[sz];

        Arrays.fill(dp, 1);

        Arrays.sort(pairs, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for(int i=sz-1; i>=0; i--){
            int cnt = 0;
            for(int j=i+1; j<sz; j++){
                if(pairs[j][0] > pairs[i][1]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}