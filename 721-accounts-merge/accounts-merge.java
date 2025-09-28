class Solution {
    private int vis[] = null;
    private Map<String, List<Integer>> mp = new HashMap<>();
    private Set<String> used = new HashSet<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int sz = accounts.size();
        List<List<String>> ans = new ArrayList<>();
        vis = new int[sz];

        for(int i=0; i<sz; i++){
            List<String> values = accounts.get(i);
            for(int j=1; j<values.size(); j++){
                if(!mp.containsKey(values.get(j))){
                    mp.put(values.get(j), new ArrayList<>());
                }
                mp.get(values.get(j)).add(i);
            }
        }

        for(int i=0; i<sz; i++){
            if(vis[i] == 0){
                List<String> list = new ArrayList<>();
                list.addAll(getList(accounts, i));
                Collections.sort(list);
                list.add(0, accounts.get(i).get(0));
                // System.out.println(getList(accounts, i));
                ans.add(list);
            }
        }

        return ans;
    }

    private List<String> getList(List<List<String>> accounts, int i){
        vis[i] = 1;

        List<String> emails = accounts.get(i), list = new ArrayList<>();
        int sz = emails.size();

        for(int j=1; j<sz; j++){
            if(!used.contains(emails.get(j))){
                list.add(emails.get(j));
                used.add(emails.get(j));
            }
            for(int k : mp.get(emails.get(j))){
                if(vis[k] == 0) list.addAll(getList(accounts, k));
            }
        }

        return list;
    }
}