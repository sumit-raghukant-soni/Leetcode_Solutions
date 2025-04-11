class Solution {
    private int vis[] = new int[26];
    private Map<Integer, List<Integer>> mp = new HashMap<>();
    private Map<Integer, Integer> group_mpg = new HashMap<>();
    public boolean equationsPossible(String[] equations) {
        int sz = equations.length;

        for(int i=0; i<26; i++){
            mp.put(i, new ArrayList<>());
        }

        for(int i=0; i<sz; i++){
            int u = equations[i].charAt(0) - 'a', v = equations[i].charAt(3) - 'a';
            int relation = equations[i].charAt(1) == '!' ? 1 : 2;
            if(relation == 2){
                mp.get(u).add(v);
                mp.get(v).add(u);
            }
        }

        int k=0;
        for(int i=0; i<26; i++){
            if(vis[i] == 0) dfs(i, k++);
        }

        for(int i=0; i<sz; i++){
            int u = equations[i].charAt(0) - 'a', v = equations[i].charAt(3) - 'a';
            int relation = equations[i].charAt(1) == '!' ? 1 : 2;
            if(relation == 1){
                if(group_mpg.get(u) == group_mpg.get(v)) return false;
            }
        }

        return true;
    }

    private void dfs(int i, int k){
        vis[i] = 1;
        group_mpg.put(i, k);
        
        for(int j : mp.get(i)){
            if(vis[j] == 0){
                dfs(j, k);
            }
        }
    }
}