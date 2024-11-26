class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] degree = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        HashMap<Pair<Integer, Integer>, Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++) adjList.add(new ArrayList<>());

        for(int i=0; i<edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
        }

        for(int i=0; i<n; i++){
            List<Integer> curr = adjList.get(i);
            for(int j=0; j<curr.size(); j++){
                degree[curr.get(j)]++;
            }
        }

        int cnt = 0, ans = 0;
        for(int i=0; i<n; i++){
            if(degree[i] == 0){
                cnt++; ans = i;
            }
        }

        return (cnt > 1 || cnt == 0) ? -1 : ans;
    }
}