class ExamRoom {
    int N, sz = 0;
    List<Integer> lst = new ArrayList<>();
    public ExamRoom(int n) {
       N = n; 
    }
    
    public int seat() {
        if(sz == 0) {
            lst.add(0);
            sz++;
            return 0;
        }
        int d = Math.max( lst.get(0), N - 1 - lst.get(sz-1) );
        for(int i=0; i<sz-1; ++i) {
            d = Math.max(d, (lst.get(i+1) - lst.get(i)) / 2);
        }

        // System.out.println(lst + " " + d);
        if(lst.get(0) == d) {
            lst.add(0, 0);
            sz++;
            return 0;
        }

        for(int i=0; i<sz-1; ++i) {
            if( (lst.get(i+1) - lst.get(i))/2 == d ) {
                lst.add( i+1, (lst.get(i+1) + lst.get(i)) / 2 );
                sz++;
                return lst.get(i+1);
            }
        }

        lst.add(N-1);
        sz++;
        return N-1;
    }
    
    public void leave(int p) {
        for(int i=0; i<sz; i++) {
            if(lst.get(i) == p) {
                lst.remove(i);
                sz--;
                break;
            }
        }
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */