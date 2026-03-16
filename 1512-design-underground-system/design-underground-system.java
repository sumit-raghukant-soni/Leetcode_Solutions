class UndergroundSystem {
    Map<String, Double> mp;
    Map<String, Integer> count;
    Map<Integer, Pair<String, Integer>> tmp;
    public UndergroundSystem() {
        mp = new HashMap<>();
        tmp = new HashMap<>();
        count = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if(!tmp.containsKey(id)) tmp.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        int t1 = tmp.get(id).getValue();
        String key = tmp.get(id).getKey() + "+" + stationName;
        if(!mp.containsKey(key)){
            mp.put(key, new Double(t - t1));
            count.put(key, 1);
        }
        else {
            mp.put(key, (mp.get(key) * count.get(key) + (t-t1)) / (count.get(key) + 1.0) );
            count.put(key, count.get(key) + 1);
        }
        tmp.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return mp.getOrDefault(startStation + "+" + endStation, 0.0);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */