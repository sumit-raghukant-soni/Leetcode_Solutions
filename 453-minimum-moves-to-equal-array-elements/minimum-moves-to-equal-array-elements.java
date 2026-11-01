class Solution {
    public int minMoves(int[] nums) {
        int sz = nums.length, mini = Integer.MAX_VALUE, ans = 0;

        for(int i=0; i<sz; i++) {
            mini = mini < nums[i] ? mini : nums[i];
        }

        for(int i=0; i<sz; i++) {
            ans += nums[i] - mini;
        }

        return ans;
    }
}