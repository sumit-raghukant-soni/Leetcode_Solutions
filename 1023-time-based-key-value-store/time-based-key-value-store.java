class TimeMap {
    Map<String, TreeMap<Integer, String>> mp = null;

    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key)) mp.put(key, new TreeMap<>());
        mp.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> mp2 = mp.get(key);
        if(mp2 == null) return "";
        
        Map.Entry<Integer, String> entry = mp2.floorEntry(timestamp);
        
        if(entry == null) return "";
        return entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */