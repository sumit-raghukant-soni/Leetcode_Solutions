class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        int sz = orders.size();
        List<String> row = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        TreeSet<String> cols = new TreeSet<>();
        TreeMap<Integer, Map<String, Integer>> mp = new TreeMap<>();

        for(int i=0; i<sz; i++){
            int id = Integer.valueOf(orders.get(i).get(1));
            String dish = orders.get(i).get(2);
            if(!mp.containsKey(id)) mp.put(id, new HashMap<>());
            mp.get(id).put(dish, mp.get(id).getOrDefault(dish, 0) + 1);
            cols.add(dish);
        }

        row.add("Table");
        for(String col : cols){
            row.add(col);
        }
        ans.add(row);

        for(Map.Entry<Integer, Map<String, Integer>> e : mp.entrySet()){
            row = new ArrayList<>();
            row.add(e.getKey() + "");
            for(String col : cols){
                row.add(e.getValue().getOrDefault(col, 0) + "");
            }
            ans.add(row);
        }

        return ans;
    }
}