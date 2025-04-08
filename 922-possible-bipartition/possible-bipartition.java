class Solution {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private int[] vis;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int sz = dislikes.length;
        
        vis = new int[n+1];
        Arrays.fill(vis, -1);

        for(int i=1; i<=n; i++) adjList.put(i, new ArrayList<>());

        for(int i=0; i<sz; i++){
            int u = dislikes[i][0], v = dislikes[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for(int i=1; i<=n; i++){
            if(vis[i] == -1){
                if(!solve(i)) return false;
            }
        }

        // for(int i=1; i<=n; i++){
        //     System.out.println(vis[i] + ",");
        // }

        return true;
    }

    private boolean solve(int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        int val = 1;
        vis[i] = val;

        while(!q.isEmpty()){
            int curr = q.poll();
            val = vis[curr];
            vis[curr] = 0;
            for(int j : adjList.get(curr)){
                if(vis[j] == -1){
                    vis[j] = val == 1 ? 2 : 1;
                    q.add(j);
                }
                else if(vis[j] == val) return false;
            }
            vis[curr] = val;
        }

        return true;
    }
}