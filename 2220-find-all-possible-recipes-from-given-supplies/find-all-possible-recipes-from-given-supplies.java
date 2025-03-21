class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int sz1 = recipes.length;
        List<String> ans = new ArrayList<>(), toBeRemoved1 = new ArrayList<>(), toBeRemoved2 = new ArrayList<>();
        Set<String> avail = new HashSet<>();
        Map<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<sz1; i++){
            List<String> ind = new ArrayList<>();
            for(String j : ingredients.get(i)){
                ind.add(j);
            }
            mp.put(recipes[i], ind);
        }

        for(int i=0; i<supplies.length; i++){
            avail.add(supplies[i]);
        }

        int sz, tmp, cnt = 1;
        while(cnt > 0){
            cnt = 0;
            // System.out.println(mp);
            // System.out.println(ans);
            for(Map.Entry<String, List<String>> p : mp.entrySet()){
                sz = p.getValue().size(); tmp = 0;
                for(String ind : p.getValue()){
                    if(avail.contains(ind)){
                        tmp++;
                        toBeRemoved1.add(ind);            
                    }
                }
                if(sz == tmp){
                    avail.add(p.getKey());
                    ans.add(p.getKey());
                    toBeRemoved2.add(p.getKey());
                    cnt++;
                }
                mp.get(p.getKey()).removeAll(toBeRemoved1);
                toBeRemoved1.clear();
            }
            for(String recipe : toBeRemoved2){
                mp.remove(recipe);
            }
            toBeRemoved2.clear();
        }

        return ans;
    }
}