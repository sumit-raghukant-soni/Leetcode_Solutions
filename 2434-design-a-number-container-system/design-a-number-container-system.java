class NumberContainers {

    private Map<Integer, SortedSet<Integer>> mp;
    private Map<Integer, Integer> mpg;

    public NumberContainers() {
        mp = new HashMap<>();
        mpg = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(!mp.containsKey(number)){
            mp.put(number, new TreeSet<>());
        }
        if(mpg.containsKey(index)){
            mp.get(mpg.get(index)).remove(index);
        }
        mpg.put(index, number);
        mp.get(number).add(index);
    }
    
    public int find(int number) {
        if(mp.containsKey(number) && !mp.get(number).isEmpty()) return mp.get(number).first();
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */