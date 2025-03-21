class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int sz1 = recipes.length;
        List<String> ans = new ArrayList<>();
        List<String> ingredientsToRemove = new ArrayList<>(); 
        List<String> recipeToRemove = new ArrayList<>();
        Set<String> avail = new HashSet<>();
        Map<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<supplies.length; i++){
            avail.add(supplies[i]);
        }

        for(int i=0; i<sz1; i++){
            List<String> ind = new ArrayList<>();
            for(String j : ingredients.get(i)){
                if(!avail.contains(j)) ind.add(j);
            }
            mp.put(recipes[i], ind);
        }


        int sz, tmp, cnt = 1;
        while(cnt > 0){
            cnt = 0;
            for(Map.Entry<String, List<String>> p : mp.entrySet()){
                sz = p.getValue().size(); tmp = 0;
                for(String ind : p.getValue()){
                    if(avail.contains(ind)){
                        tmp++;
                        ingredientsToRemove.add(ind);            
                    }
                }
                if(sz == tmp){
                    avail.add(p.getKey());
                    ans.add(p.getKey());
                    recipeToRemove.add(p.getKey());
                    cnt++;
                }
                mp.get(p.getKey()).removeAll(ingredientsToRemove);
                ingredientsToRemove.clear();
            }
            for(String recipe : recipeToRemove){
                mp.remove(recipe);
            }
            recipeToRemove.clear();
        }

        return ans;
    }
}