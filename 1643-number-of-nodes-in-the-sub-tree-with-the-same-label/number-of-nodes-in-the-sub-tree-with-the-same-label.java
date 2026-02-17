class Solution {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    int vis[] = null;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int sz = edges.length;
        int ans[] = new int[n];
        vis = new int[n];
        
        for(int i=0; i<n; i++) adjList.put(i, new ArrayList<>());

        for(int i=0; i<sz; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        solve(adjList, ans, labels, 0);

        return ans;
    }

    private int[] solve(Map<Integer, List<Integer>> adjList, int[] ans, String labels, int curr) {
        // System.out.println(curr);
        vis[curr] = 1;
        int f[] = new int[26];

        for(int i : adjList.get(curr)){
            // System.out.println(curr + " called " + i);
            if(vis[i] == 1) continue;
            int tmp[] = solve(adjList, ans, labels, i);
            for(int j=0; j<26; j++){
                f[j] += tmp[j];
            }
        }

        f[labels.charAt(curr) - 'a']++;
        ans[curr] = f[labels.charAt(curr) - 'a'];

        return f;
    }
}