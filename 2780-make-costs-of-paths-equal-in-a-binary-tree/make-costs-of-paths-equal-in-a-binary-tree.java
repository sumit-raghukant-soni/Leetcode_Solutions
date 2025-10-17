class Solution {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;

        for(int i=n-1; i>0; i-=2){
            int a = cost[i], b = cost[i-1];
            ans += a > b ? (a-b) : (b-a);
            cost[(i-1)/2] += a > b ? a : b;
        }

        return ans;
    }
}