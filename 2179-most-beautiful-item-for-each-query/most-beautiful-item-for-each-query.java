class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        int sz = queries.length, ans[] = new int[sz];

        for(int i=0; i<items.length; i++){
            if(mp.containsKey(items[i][0])){
                mp.put(items[i][0], Math.max(items[i][1], mp.get(items[i][0])));
            }
            else{
                mp.put(items[i][0], items[i][1]);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> itr = mp.entrySet().iterator();
        int maxi = 0;
        while(itr.hasNext()){
            Map.Entry<Integer, Integer> entry = itr.next();
            maxi = Math.max(maxi, entry.getValue());
            entry.setValue(maxi);
        }

        for(int i=0; i<sz; i++){
            Integer key = mp.floorKey(queries[i]);
            if(key != null) ans[i] = mp.get(key);
            else ans[i] = 0;
        }

        return ans;
    }
}