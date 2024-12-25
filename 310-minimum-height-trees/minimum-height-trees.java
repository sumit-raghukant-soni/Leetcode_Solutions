class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int degree[] = new int[n], sz = edges.length;
        List<Integer> centers = new ArrayList<>();
        if(sz == 0){
            centers.add(0);
            return centers;
        }
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i=0; i<sz; i++){
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
            adjList.putIfAbsent(edges[i][0], new ArrayList<>());
            adjList.putIfAbsent(edges[i][1], new ArrayList<>());
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i=0; i<n; i++){
            if(degree[i] == 1){
                q.add(i);
            }
        }

        int leafRemoved = 0;
        while(n-leafRemoved > 2){
            sz = q.size();
            leafRemoved += sz;
            System.out.println(sz);
            for(int i=0; i<sz; i++){
                int curr = q.poll();
                for(int neighbour : adjList.get(curr)){
                    degree[neighbour]--;
                    if(degree[neighbour] == 1) q.add(neighbour);
                }
            }
        }

        centers.addAll(q);
        return centers;
    }
}