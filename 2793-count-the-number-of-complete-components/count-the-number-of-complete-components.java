class Solution {
    private Set<Integer> vis = new HashSet<>();
    private Map<Integer, List<Integer>> mp = new HashMap<>();
    public int countCompleteComponents(int n, int[][] edges) {
        int sz = edges.length, u, v, ans = 0;
        List<Integer> component = new ArrayList<>();

        for(int i=0; i<n; i++){
            mp.put(i, new ArrayList<>());
        }

        for(int i=0; i<sz; i++){
            u = edges[i][0]; v = edges[i][1];
            mp.get(u).add(v);
            mp.get(v).add(u);
        }

        boolean flg = false;
        int compSz;
        for(int i=0; i<n; i++){
            if(!vis.contains(i)){
                explore(component, i);
                compSz = component.size();
                flg = true;
                for(int j : component){
                    if(mp.get(j).size() != compSz-1){
                        flg = false; break;
                    }
                }
                if(flg) ans++;
                component.clear();
            }
        }

        return ans;
    }

    private void explore(List<Integer> component, int curr){
        vis.add(curr);
        component.add(curr);

        for(int i : mp.get(curr)){
            if(!vis.contains(i)){
                explore(component, i);
            }
        }
    }
}