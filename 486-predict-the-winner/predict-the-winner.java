class Solution {
    private boolean ans = false;
    private int a = 0, b = 0;
    private int[][] dp = null;
    public boolean predictTheWinner(int[] nums) {
        int sz = nums.length, totalSum = 0;
        dp = new int[sz][sz];

        for(int i=0; i<sz; i++){
            totalSum += nums[i];
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(nums, 0, sz-1);

        return (1.0 * ans) >= ((1.0 * totalSum)/2);
    }

    private int solve(int nums[], int s, int e){
        if(s > e) return 0;
        if(dp[s][e] != -1) return dp[s][e];

        int l, r;
        l = nums[s] + Math.min(solve(nums, s+2, e), solve(nums, s+1, e-1));
        r = nums[e] + Math.min(solve(nums, s, e-2), solve(nums, s+1, e-1));

        return dp[s][e] = Math.max(l, r);
    }
}