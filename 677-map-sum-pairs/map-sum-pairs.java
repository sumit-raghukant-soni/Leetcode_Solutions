class MapSum {
    private HashMap<String, Integer> mp;
    public MapSum() {
        mp = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        mp.put(key, val);
    }
    
    public int sum(String prefix) {
        int ans = 0, sz = prefix.length();
        for(Map.Entry<String, Integer> pair : mp.entrySet()){
            if(pair.getKey().length() >= sz && pair.getKey().substring(0, sz).equals(prefix)) ans += pair.getValue();
        }
        return ans;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */