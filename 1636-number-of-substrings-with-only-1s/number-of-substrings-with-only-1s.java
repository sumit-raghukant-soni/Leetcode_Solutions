class Solution {
    public int numSub(String s) {
        int sz = s.length();
        long ans = 0, MOD = 1_000_000_007;

        for(int i=0; i<sz; i++){
            int cnt = 0;
            while(i<sz && s.charAt(i) == '1'){
                i++; cnt++;
            }
            ans += (1L * cnt * (cnt+1))/2;
            ans = (ans % MOD);
        }

        return (int) ans;
    }
}