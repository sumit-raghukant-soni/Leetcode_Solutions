class Solution {
    double values[] = null, totalFreq[] = null, currFreq[];
    int sz = -1, curr = 0;
    public Solution(int[] w) {
        sz = w.length;
        double tmp[][] = new double[sz][2], total = 0;
        for(int i=0; i<sz; i++){
            tmp[i][0] = w[i];
            tmp[i][1] = i;
        }

        Arrays.sort(tmp, (a, b) -> {
            return ((int) b[0]) - ((int) a[0]);
        });
        
        values = new double[sz]; currFreq = new double[sz]; totalFreq = new double[sz];
        
        for(int i=0; i<sz; i++) total += tmp[i][0];

        for(int i=0; i<sz; i++){
            tmp[i][0] = 1 + (tmp[i][0] / total) * 100;
            currFreq[i] = tmp[i][0];
            totalFreq[i] = tmp[i][0];
            values[i] = tmp[i][1];
        }
    }
    
    public int pickIndex() {
        if(currFreq[curr] <= 0){
            currFreq[curr] = totalFreq[curr];
            curr = (curr+1)%sz;
        }

        currFreq[curr]--;
        return (int) values[curr];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */