class Solution {
    private long cnt = 1L;
    private long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long even = 5, odd = 4;
        int t = 0;

        long oddMul = findPow(odd, n/2), evenMul = findPow(even, (n/2) + ((n%2 == 1) ? 1 : 0));

        // System.out.println(oddMul + " " + evenMul);

        return (int) ((oddMul * evenMul)%MOD);
    }

    private long findPow(long num, long p){
        long res = 1;

        // num = num%MOD;
        // p = p%MOD;
        // System.out.println(num + " " + p);

        while(p > 0){
            if((p&1) == 1){
                res = (res*num)%MOD;
            }
            num = (num*num)%MOD;
            p >>= 1;
        }
        return res;
    }
}