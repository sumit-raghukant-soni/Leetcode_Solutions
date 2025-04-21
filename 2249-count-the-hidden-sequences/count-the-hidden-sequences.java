class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int sz = differences.length;
        long curr = 0, l = 0, r = 0;

        for(int i=0; i<sz; i++){
            curr += differences[i];
            l = Math.min(curr, l);
            r = Math.max(curr, r);
        }   

        // System.out.println(r + " " + l);
        // System.out.println( (1L * upper - lower + 1) + " " + (r - l + 1) );
        if((1L * upper - lower + 1) < (r - l +1)) return 0;
        return (int) ((1L * upper - lower + 1) - (r - l +1) + 1);
    }
}