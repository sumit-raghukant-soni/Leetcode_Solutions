class Solution {
    private boolean ans = false;
    private int[][] vis;
    public boolean canPartition(int[] nums) {
        int sz = nums.length, sum = 0;
        vis = new int[sz][20001];

        for(int i=0; i<sz; i++){
            sum += nums[i];
        }

        if((sum&1) == 1) return false;

        solve(nums, sz, sum/2, 0);

        return ans;
    }

    private void solve(int[] nums, int sz, int sum, int ind){
        if(sum == 0){
            ans = true;
            return;
        }
        if(ind == sz || ans || vis[ind][sum] == 1) return;

        vis[ind][sum] = 1;
        solve(nums, sz, sum, ind+1);
        if(nums[ind] <= sum) solve(nums, sz, sum-nums[ind], ind+1);
    }
}