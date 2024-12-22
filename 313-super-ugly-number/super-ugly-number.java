class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int sz = primes.length;
        int idx[] = new int[sz];
        long uglyNums[] = new long[n], val[] = new long[sz];
        Arrays.fill(val, 1);

        long potentialValue = 1;
        for(int i=0; i<n; i++){
            uglyNums[i] = potentialValue;

            potentialValue = Integer.MAX_VALUE;
            for(int j=0; j<sz; j++){
                if(val[j] == uglyNums[i]) val[j] = uglyNums[idx[j]++] * primes[j];
                potentialValue = Math.min(potentialValue, val[j]*1L);
            }
        }

        return Math.toIntExact(uglyNums[n-1]);
    }
}