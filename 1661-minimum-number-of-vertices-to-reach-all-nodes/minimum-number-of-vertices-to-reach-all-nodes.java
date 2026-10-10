class Solution {
    Map<Integer, List<Integer>> mp = new HashMap<>();
    Set<Integer> st = new HashSet<>();
    int vis[] = null;
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int sz = edges.size();
        vis = new int[n];
        Arrays.fill(vis, -1);

        for(int i=0; i<sz; i++) {
            int u = edges.get(i).get(0), v = edges.get(i).get(1);
            mp.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        for(int i=0; i<n; i++) {
            if(vis[i] == -1) {
                solve(i);
            }
        }

        return new ArrayList<>(st);
    }

    private void solve(int i) {
        vis[i] = 1;

        if(mp.get(i) == null) {
            st.add(i);
            return;
        }

        for(int j : mp.get(i)) {
            if(vis[j] == -1) {
                solve(j);
            }
        }

        return;
    }
}