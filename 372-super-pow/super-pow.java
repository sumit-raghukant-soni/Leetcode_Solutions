class Solution {
    private int MOD = 1337;
    public int superPow(int a, int[] b) {
        int sz = b.length, ans = 0, k = 0, prev = 1, next = 0;

        for(int i=0; i<sz; i++){
            prev = pow(prev, 10);
            next = pow(a, b[i]);
            ans = (prev * next) % MOD;
            prev = ans;
        }

        return ans;
    }

    private int pow(int a, int b){
        int val = 1;
        a %= MOD;

        while(b > 0){
            if((b&1) == 1) val = (val * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        
        return val;
    }
}