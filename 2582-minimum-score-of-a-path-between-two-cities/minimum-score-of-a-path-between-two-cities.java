class Solution {
    public int minScore(int n, int[][] roads) {
        int sz = roads.length, ans = Integer.MAX_VALUE, u, v, dis;
        int vis[] = null, mini[] = null;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        vis = new int[n+1];
        mini = new int[n+1];
        Arrays.fill(vis, -1);
        Arrays.fill(mini, Integer.MAX_VALUE);

        for(int i=1; i<=n; i++){
            mp.put(i, new ArrayList<>());
        }

        for(int i=0; i<sz; i++){
            u = roads[i][0]; v = roads[i][1]; dis = roads[i][2];
            mini[u] = Math.min(mini[u], dis);
            mini[v] = Math.min(mini[v], dis);
            mp.get(u).add(v);
            mp.get(v).add(u);
        }

        q.add(1);
        while(!q.isEmpty()){
            int curr = q.poll();
            vis[curr] = 1;
            ans = Math.min(ans, mini[curr]);
            for(int i : mp.get(curr)){
                if(vis[i] == -1){
                    q.add(i);
                }
            }
        }

        return ans;
    }
}