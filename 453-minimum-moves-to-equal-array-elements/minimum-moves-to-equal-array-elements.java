class Solution {
    public int minMoves(int[] nums) {
        int sz = nums.length, ans = 0, mini = nums[0];

        for(int i=0; i<sz; i++){
            mini = Math.min(mini, nums[i]);
        }

        for(int i=0; i<sz; i++){
            ans += nums[i] - mini;
        }

        return ans;
    }
}