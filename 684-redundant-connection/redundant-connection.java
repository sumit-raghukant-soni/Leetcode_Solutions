class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int sz = edges.length;
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i=0; i<sz; i++) adjList.put(i+1, new ArrayList<>());

        for(int i=0; i<sz; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i=sz-1; i>=0; i--){
            if(check(adjList, edges[i][0], edges[i][1])) return edges[i];
        }

        return null;
    }

    public boolean check(Map<Integer, List<Integer>> adjList, int a, int b){
        int n = adjList.size();
        Set<Integer> st = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()){
            Integer curr = q.poll();
            st.add(curr);
            for(int i : adjList.get(curr)){
                if(!st.contains(i) && !(a == curr && b == i) && !(a == i && b == curr)) q.add(i);
            }
        }

        return st.size() == n;
    }
}