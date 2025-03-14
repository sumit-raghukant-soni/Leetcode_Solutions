class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int ans = Integer.MIN_VALUE;
        int vis[] = new int[n+1];
        Map<Integer, List<Pair<Integer, Integer>>> adjList = new HashMap<>();
        Pair<Integer, Integer> p = null;

        Arrays.fill(vis, Integer.MAX_VALUE);
        for(int i=1; i<=n; i++) adjList.put(i, new ArrayList<>());

        for(int i=0; i<times.length; i++){
            p = new Pair(times[i][1], times[i][2]);
            adjList.get(times[i][0]).add(p);
        }

        solve(adjList, vis, 0, k);

        for(int i=1; i<=n; i++){
            // System.out.print(i + ":" + vis[i] + ", ");
            if(i == k) continue;
            ans = Math.max(ans, vis[i]);
        }   

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void solve(Map<Integer, List<Pair<Integer, Integer>>> adjList, int[] vis, int time, int curr){
        vis[curr] = time;
        for(Pair<Integer, Integer> i : adjList.get(curr)){
            if(vis[i.getKey()] > (time+i.getValue())){
                solve(adjList, vis, time+i.getValue(), i.getKey());
            }
        }
    }
}