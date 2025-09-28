class Solution {
    private Map<Integer, List<Integer>> mp = new HashMap<>();
    private int ans = 0, vis[] = null;
    private List<Boolean> containsApple = null;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int sz = hasApple.size(), sz2 = edges.length;
        vis = new int[sz];
        containsApple = hasApple;

        for(int i=0; i<sz; i++){
            mp.put(i, new ArrayList<>());
        }

        for(int i=0; i<sz2; i++){
            int u = edges[i][0], v = edges[i][1];
            mp.get(u).add(v);
            mp.get(v).add(u);
        }

        int ans = solve(0);

        return ans;
    }

    private int solve(int i){
        vis[i] = 1;

        int cost = 0;
        for(int child : mp.get(i)){
            if(vis[child] == 0){
                cost += solve(child);
            }
        }

        if(i != 0 && (containsApple.get(i) || cost > 0)) cost += 2;
        // System.out.println(i + " " + cost);

        return cost;
    }
}