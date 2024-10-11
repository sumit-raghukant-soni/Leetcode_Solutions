class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int cnt = 0, sz = times.length, target = times[targetFriend][0];
        SortedSet<Pair> inUse = new TreeSet<>();
        SortedSet<Integer> free = new TreeSet<>();
        Pair2[] seats = new Pair2[sz];
        
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i=0; i<sz; i++){
            var itr = inUse.iterator();
            while(itr.hasNext()){
                Pair p = itr.next();
                if(p.key > times[i][0]) break;
                free.add(p.value);
                itr.remove();
            }
            if(!free.isEmpty()){
                int tmp = free.first();
                free.remove(tmp);
                seats[i] = new Pair2(times[i][0], tmp);
                inUse.add(new Pair(times[i][1], tmp));
            }
            else{
                seats[i] = new Pair2(times[i][0], cnt);
                inUse.add(new Pair(times[i][1], cnt++));
            }
        }

        for(int i=0; i<sz; i++){
            if(seats[i].entry == target) return seats[i].seat;
        }
        return -1;
    }
}

class Pair implements Comparable<Pair>{
    public int key, value;
    public Pair(Integer key, Integer value){
        this.key = key;
        this.value = value;
    }

    public int compareTo(Pair o) {
        if (this.key != o.key) {
            return Integer.compare(this.key, o.key);
        } else {
            return Integer.compare(this.value, o.value);
        }
    }
}

class Pair2{
    public int entry, seat;
    public Pair2(Integer entry, Integer seat){
        this.entry = entry;
        this.seat = seat;
    }
}