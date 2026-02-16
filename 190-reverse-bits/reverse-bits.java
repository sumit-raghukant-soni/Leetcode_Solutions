class Solution {
    public int reverseBits(int n) {
        int ans = 0, tmp = n;

        for(int i=31; i>=0; i--){
            int rem = tmp&1;
            ans += (rem * Math.pow(2, i));
            tmp >>= 1;
        }

        return ans;
    }
}