class Solution {
    public int minMoves2(int[] nums) {
        int sz = nums.length, ans = Integer.MAX_VALUE;
        
        Arrays.sort(nums);

        if((sz&1) == 1) return calc(nums, nums[sz/2]);
        return Math.min(calc(nums, nums[sz/2]), calc(nums, nums[(sz-1)/2]));
    }

    private int calc(int[] nums, int mid){
        int sz = nums.length, ans = 0;

        for(int i=0; i<sz; i++){
            ans += Math.abs(mid - nums[i]);
        }

        return ans;
    }
}