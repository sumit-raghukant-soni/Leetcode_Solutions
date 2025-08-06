class RLEIterator {
    int curr, freq, sz;
    int[] arr = null;
    public RLEIterator(int[] encoding) {
        arr = encoding;
        curr = 1; freq = encoding[0];
        sz = encoding.length;
    }
    
    public int next(int n) {
        if(curr >= sz) return -1;

        int val = -1;
        while(curr < sz && n > 0){
            val = arr[curr];
            if(freq == 0){
                curr = curr+2; 
                if(curr < sz) freq += arr[curr-1];
            }
            else if(n > freq){
                n -= freq;
                freq = 0;
            }
            else {
                freq -= n;
                n = 0;
            }
        }

        if(curr > sz) return -1;
        return val;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */