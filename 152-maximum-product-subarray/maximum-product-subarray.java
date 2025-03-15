class Solution {
    private int ans = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        int sz = nums.length, tmp = 1;

        solve(nums, sz, nums[0], nums[0], 1);

        return ans;
    }

    private void solve(int nums[], int sz, int pos, int neg, int i){
        ans = Math.max(ans, Math.max(pos, neg));
        if(i == sz) return;

        solve(nums, sz, Math.max(nums[i], Math.max(pos*nums[i], neg*nums[i])), Math.min(nums[i], Math.min(pos*nums[i], neg*nums[i])), i+1);
    }
}