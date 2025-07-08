class Solution {
    Map<Integer, List<Integer>> mp = new HashMap<>();
    int vis[] = null;
    public int makeConnected(int n, int[][] connections) {
        int sz = connections.length, u, v, grps = 0;
        vis = new int[n];

        for(int i=0; i<n; i++){
            mp.put(i, new ArrayList<>());
        }

        for(int i=0; i<sz; i++){
            u = connections[i][0]; v = connections[i][1];
            mp.get(u).add(v);
            mp.get(v).add(u);
        }

        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                solve(i); grps++;
            }
        }

        grps--;
        return grps == 0 ? 0 : (sz >= n-1 ? grps : -1);
    }

    private void solve(int i){
        vis[i] = 1;
        
        for(int j : mp.get(i)){
            if(vis[j] == 0) solve(j);
        }

    }
}