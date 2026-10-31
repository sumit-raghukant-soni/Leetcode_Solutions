class Solution {
    private int MOD = 1_000_000_007;
    long vis[][] = new long[10][5001];
    public int knightDialer(int n) {
        long cnt = 0;

        for(int i=0; i<10; i++){
            Arrays.fill(vis[i], -1);
        }

        for(int i=0; i<=9; i++) {
            cnt += solve(i, n);
            cnt %= MOD;
        }

        return (int) cnt;
    }

    int path[][] = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
    private long solve(int curr, int n) {
        if(n == 1) return 1;
        if(vis[curr][n] != -1) return vis[curr][n];

        long ans = 0;
        for(int i : path[curr]) {
            ans += solve(i, n-1);
            ans %= MOD;
        }

        vis[curr][n] = ans;
        return ans;
    }
}