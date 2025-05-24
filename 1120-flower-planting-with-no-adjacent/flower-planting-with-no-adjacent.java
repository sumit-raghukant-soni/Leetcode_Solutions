class Solution {
    private List<Integer>[] mp = null;
    private int[] ans = null;
    private int colorUsed[] = new int[5];
    public int[] gardenNoAdj(int n, int[][] paths) {
        int sz = paths.length, u, v;
        mp = new ArrayList[n+1];
        ans = new int[n];

        for(int i=1; i<=n; i++){
            mp[i] = new ArrayList<>();
        }

        for(int i=0; i<sz; i++){
            u = paths[i][0]; v = paths[i][1];
            mp[u].add(v);
            mp[v].add(u);
        }

        for(int i=1; i<=n; i++){
            if(ans[i-1] == 0) solve(i);
        }

        return ans;
    }

    private void solve(int i){
        if(ans[i-1] != 0) return;

        Arrays.fill(colorUsed, 0);
        for(int j : mp[i]){
            colorUsed[ans[j-1]]++;
        }

        for(int j=1; j<=4; j++){
            if(colorUsed[j] == 0){
                ans[i-1] = j;
                break;
            }
        }

        for(int j : mp[i]){
            if(ans[j-1] == 0) solve(j);
        }

    }
}