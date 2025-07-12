class Solution {
    int MOD = 1000000007, dis[] = null;
    long vis[] = null;
    Map<Integer, List<Pair<Integer, Integer>>> mp = new HashMap<>();
    public int countRestrictedPaths(int n, int[][] edges) {
        int sz = edges.length;
        long ans = 0L;
        dis = new int[n+1];
        vis = new long[n+1];
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(int i=1; i<=n; i++) mp.put(i, new ArrayList<>());

        for(int i=0; i<sz; i++){
            int u = edges[i][0], v = edges[i][1];
            mp.get(u).add(new Pair(v, edges[i][2]));
            mp.get(v).add(new Pair(u, edges[i][2]));
        }

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[n] = 0; vis[n] = 1;
        pq.add(new Pair(n, 0));
        while(!pq.isEmpty()){
            int curr = pq.peek().getKey(), dist = pq.peek().getValue();
            pq.poll();
            if(dist > dis[curr]) continue;

            for(Pair<Integer, Integer> j : mp.get(curr)){
                if(dis[j.getKey()] > (dis[curr] + j.getValue())){
                    dis[j.getKey()] = (dis[curr] + j.getValue());
                    pq.add(new Pair(j.getKey(), dis[j.getKey()]));
                }
                if(dis[j.getKey()] > dis[curr]){
                    vis[j.getKey()] = (vis[j.getKey()] + vis[curr]) % MOD;
                }
            }
        }

        return (int) vis[1];
    }
}