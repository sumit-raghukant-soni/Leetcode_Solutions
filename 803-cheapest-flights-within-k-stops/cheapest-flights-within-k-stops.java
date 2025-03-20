class Solution {
    private Map<Integer, List<Pair<Integer, Integer>> > mp = new HashMap<>();
    private Map<Integer, Integer> vis = new HashMap<>();
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            mp.put(i, new ArrayList<>());
        }

        int u, v, w;
        for(int i=0; i<flights.length; i++){
            u = flights[i][0]; v = flights[i][1]; w = flights[i][2];
            mp.get(u).add(new Pair(v, w));
        }

        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> q = new PriorityQueue<>((a, b) -> {
            if(a.getValue().getValue() != b.getValue().getValue()) return a.getValue().getValue() - b.getValue().getValue();
            return a.getKey() - b.getKey();
        });
        
        for(Pair<Integer, Integer> i : mp.get(src)){
            q.add(new Pair(i.getValue(), new Pair(i.getKey(), 0)));
        }

        while(!q.isEmpty()){
            int sum = q.peek().getKey(), curr = q.peek().getValue().getKey(), steps = q.peek().getValue().getValue(); 
            q.poll();
            if(vis.containsKey(curr) && vis.get(curr) < sum) continue;
            if(steps > k) break;
            vis.put(curr, sum);
            if(curr == dst){
                ans = Math.min(sum, ans);
                continue;
            }
            for(Pair<Integer, Integer> p : mp.get(curr)){
                q.add(new Pair(sum + p.getValue(), new Pair(p.getKey(), steps+1)));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}