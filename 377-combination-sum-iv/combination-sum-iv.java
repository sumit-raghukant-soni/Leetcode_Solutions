class Solution {
    private Integer ans;
    public int combinationSum4(int[] nums, int target) {
        int sz = nums.length;
        int[] dp = new int[target+1];
        for(int i=0; i<=target; i++) dp[i] = -1;
        Arrays.sort(nums);

        solve(nums, sz, target, dp);

        return dp[target];
    }

    private int solve(int[] nums, int sz, int target, int[] dp){
        if(target == 0) return 1;
        if(dp[target] != -1) return dp[target];

        int cnt = 0;
        for(int i=0; i<sz; i++){
            if(nums[i] <= target){
                cnt += solve(nums, sz, target-nums[i], dp);
            }
        }

        return dp[target] = cnt;
    }
}