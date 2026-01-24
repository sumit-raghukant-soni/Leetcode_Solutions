class Solution {
    public int minPairSum(int[] nums) {
        int sz = nums.length, ans = -1;
        Arrays.sort(nums);

        for(int i=0; i<sz/2; i++){
            ans = ans > (nums[sz - 1 - i] + nums[i]) ? ans : (nums[sz - 1 - i] + nums[i]);
        }

        return ans;
    }
}