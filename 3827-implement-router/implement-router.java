class Router {
    private int key = 0;
    class DP implements Comparable<DP> {
    // class DP {
        int s, t, d, k;
        DP(int s, int d, int t){
            this.s = s;
            this.d = d;
            this.t = t;
            this.k = key++;
        }
        
        public String toString(){
            return this.k + ":" + this.s + ":" + this.d + ":" + this.t;
        }

        @Override
        public int compareTo(DP other) {
            if(this.t != other.t) return this.t - other.t;
            if(this.s != other.s) return this.s - other.s;
            // if(this.d != other.d) return this.d - other.d;
            // return this.k - other.k;
            return this.d - other.d;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            DP other = (DP) obj;
            return compareTo(other) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, t, d);
        }
    }
    
    private int maxi = 0;
    private TreeSet<DP> pq;
    private Map<Integer, List<Integer>> tp;
    private Map<DP, Boolean> vis;
    public Router(int memoryLimit) {
        maxi = memoryLimit;
        pq = new TreeSet<>((a, b) -> {
            return a.k - b.k;
        });
        // pq = new TreeSet<>((a, b) -> {
        //     return a.k - b.k;
        //     // return a.compareTo(b);
        // });
        vis = new HashMap<>();
        tp = new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        DP packet = new DP(source, destination, timestamp);
        // System.out.println(packet + " " + pq.contains(packet));
        if(vis.containsKey(packet)) return false;
        if(pq.size() == maxi){
            // System.out.println("removing " + pq);
            forwardPacket();
            // System.out.println("removed " + pq);
        }

        pq.add(packet);
        vis.put(packet, true);
        if(!tp.containsKey(destination)) tp.put(destination, new ArrayList<>());
        tp.get(destination).add(timestamp);

        // System.out.println(pq);
        // System.out.println(tp);
        return true;
    }
    
    public int[] forwardPacket() {
        int[] response = new int[0];
        if(pq.isEmpty()) return response;

        response = new int[3];
        DP curr = pq.first();
        pq.remove(curr);
        vis.remove(curr);
        tp.get(curr.d).remove(Integer.valueOf(curr.t));
        response[0] = curr.s;
        response[1] = curr.d;
        response[2] = curr.t;
        
        // System.out.println(tp + " " + curr.d);
        return response;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(!tp.containsKey(destination)) return 0;

        return bs(tp.get(destination), startTime, endTime);
    }

    private int bs(List<Integer> lst, int from, int to){
        int sz = lst.size();
        int s = 0, e = sz-1;
        int start = 0, end = -1;

        while(s <= e){
            int mid = s + (e-s)/2;
            if(lst.get(mid) < from) s = mid + 1;
            else{
                start = mid;
                e = mid - 1;
            }
        }

        s = 0; e = sz-1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(lst.get(mid) > to) e = mid - 1;
            else{
                end = mid;
                s = mid + 1;
            }
        }

        // System.out.println("Calc " + lst + " from " + from + " to " + to);
        // System.out.println("Calc " + start + " " + end);

        if(end != -1 && from <= lst.get(start) && lst.get(end) <= to) return end - start + 1;
 
        return 0;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */