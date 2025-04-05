class Solution {
    private int ans = 0;
    public int subsetXORSum(int[] nums) {
        int sz = nums.length;
        
        solve(nums, sz, 0, 0);

        return ans;
    }

    private void solve(int[] nums, int sz, int xor, int i){
        if(i == sz){
            ans += xor;
            return;
        }

        solve(nums, sz, xor, i+1);
        solve(nums, sz, xor^nums[i], i+1);
    }
}