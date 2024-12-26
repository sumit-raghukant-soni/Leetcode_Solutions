class Solution {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        
        solve(nums, target, 0);

        return count;
    }
    private void solve(int[] nums, int target, int i){
        if(i == nums.length){
            if(target == 0) count++;
            return;
        }
        
        solve(nums, target+nums[i], i+1);
        solve(nums, target-nums[i], i+1);
    }   
}