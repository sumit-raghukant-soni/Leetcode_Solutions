class Solution {
    public int minCost(int n, int[][] edges) {
        int sz = edges.length;
        int vis[] = new int[n];
        Map<Integer, Integer> done = new HashMap<>();
        Map<Integer, List<Pair> > in = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
            );

        Arrays.fill(vis, Integer.MAX_VALUE); 

        for(int i=0; i<sz; i++){
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            if(!in.containsKey(u)) in.put(u, new ArrayList<>());
            in.get(u).add(new Pair(v, w));

            if(!in.containsKey(v)) in.put(v, new ArrayList<>());
            in.get(v).add(new Pair(u, w*2));
        }

        // System.out.println(in);
        vis[0] = 0;
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            int curr = pq.peek().getKey(), val = pq.peek().getValue();
            pq.poll();
            if(curr == n-1) break;
            if(in.get(curr) == null) continue;
            // System.out.println(curr + " " + val);
            // System.out.println(parent);

            for(Pair e : in.get(curr)){
                int node = e.getKey(), cost = e.getValue();
                // if(vis[node] > cost + val){
                // List<Integer> lst = List.of(curr, node, cost + val);
                int key = (curr * 10000000) + node;
                int key2 = (node * 10000000) + curr;
                // System.out.println(curr + ":" + node + ":" + (cost + val));
                // System.out.println(key);
                if( !done.containsKey(key) || done.get(key) > (cost + val)) {
                    vis[node] = Math.min(vis[node], cost + val);
                    pq.add(new Pair(node, vis[node]));
                    done.put(key, (cost + val));
                    done.put(key2, (cost + val));
                }
                else {
                    // System.out.println(done);
                    // System.out.println(curr + ":" + node);
                }
            }
        }

        return vis[n-1] == Integer.MAX_VALUE ? -1 : vis[n-1];
    }
}

class Pair implements Comparable<Pair> {
    private int key;
    private int val;
    Pair(int k, int v){
        this.key = k;
        this.val = v;
    }

    public int getKey(){
        return this.key;
    }

    public int getValue(){
        return this.val;
    }

    @Override
    public int compareTo(Pair o) {
        return (this.key - o.key) + (this.val - o.val); 
    }

    @Override
    public boolean equals(Object o) {
        Pair p = (Pair) o;
        return this.key == p.key && this.val == p.val; 
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(key, val);
    }

    @Override
    public String toString() {
        return this.key + ":" + this.val; 
    }
}