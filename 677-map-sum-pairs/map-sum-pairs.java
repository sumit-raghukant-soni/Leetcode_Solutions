class MapSum {
    private HashMap<String, Integer> mp;
    private HashMap<String, Integer> st;
    public MapSum() {
        mp = new HashMap<>();
        st = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        boolean contains = st.containsKey(key);
        int sz = key.length(), oldVal = st.getOrDefault(key, 0);
        String tmp = "";

        st.put(key, val);

        for(int i=0; i<sz; i++){
            tmp += key.charAt(i);
            if(contains) mp.put(tmp, mp.getOrDefault(tmp, 0) + val - oldVal);
            else mp.put(tmp, mp.getOrDefault(tmp, 0) + val);
        }
    }
    
    public int sum(String prefix) {
        if(!mp.containsKey(prefix)) return 0;
        return mp.get(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */