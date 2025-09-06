class SnapshotArray {
    int sz = 0, sID = 0;
    TreeMap<Integer, Integer>[] arr = null;
    public SnapshotArray(int length) {
        int sz = length;
        arr = new TreeMap[sz];
        for(int i=0; i<sz; i++){
            arr[i] = new TreeMap<>();
            arr[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        arr[index].put(sID, val);
    }
    
    public int snap() {
        return sID++;
    }
    
    public int get(int index, int snap_id) {
        return arr[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */