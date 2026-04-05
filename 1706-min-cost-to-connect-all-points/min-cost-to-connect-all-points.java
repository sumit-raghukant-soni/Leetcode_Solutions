class Solution {
    public int minCostConnectPoints(int[][] points) {
        int sz = points.length, DEFAULT_VALUE = Integer.MAX_VALUE, ans = 0;
        int vis[] = new int[sz], k = 0;
        long dp[][] = new long[sz][sz];
        PriorityQueue< Pair<Integer, Pair<Integer, Integer> > > pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        Map<Integer, List<Integer>> mp = new HashMap<>();

        Arrays.fill(vis, -1);

        for(int i=0; i<sz; i++){
            for(int j=i+1; j<sz; j++){
                if(i == j){
                    dp[i][j] = DEFAULT_VALUE;
                }
                else {
                    dp[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                }
                pq.add(new Pair( (int) dp[i][j], new Pair(i, j)));
            }
        }        

        int cnt = 0;
        while(!pq.isEmpty() && cnt <= sz){
            int cost = pq.peek().getKey(), r = pq.peek().getValue().getKey(), c = pq.peek().getValue().getValue();
            pq.poll();

            if(vis[r] == -1 && vis[c] == -1){
                mp.put(k, new ArrayList<>(Arrays.asList(r, c)));
                vis[r] = vis[c] = k++;
                ans += cost;    
                cnt += 2;
            }
            else if(vis[r] == -1 || vis[c] == -1){
                if(vis[r] == -1) {
                    vis[r] = vis[c];
                    if(mp.containsKey(vis[c])) mp.get(vis[c]).add(r);
                } 
                else {
                    vis[c] = vis[r];
                    if(mp.containsKey(vis[r])) mp.get(vis[r]).add(c);
                }
                
                ans += cost;    
                cnt++;
            }
            else if(vis[r] != vis[c]) {

                if(mp.containsKey(vis[r])){
                    int cKey = vis[c];
                    mp.get(vis[r]).addAll(mp.get(vis[c]));
                    for(Integer e : mp.get(vis[c])){
                        vis[e] = vis[r];
                    }
                    mp.remove(cKey);
                }

                ans += cost;    
            }
            // for(int i=0; i<sz; i++){
            //     System.out.print(vis[i] + ",");
            // }
            // System.out.println(cost + " <> " + ans);
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}