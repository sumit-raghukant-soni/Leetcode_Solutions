class Solution {
    public long minEnd(int n, int x) {
        long ans = x;

        for(int i=1; i<n; i++){
            ans = (ans+1) | x;
        }

        return ans;
    }
}