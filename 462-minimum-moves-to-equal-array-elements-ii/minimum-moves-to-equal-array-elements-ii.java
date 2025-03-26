class Solution {
    public int minMoves2(int[] nums) {
        int sz = nums.length, ans = Integer.MAX_VALUE;
        int a, b, aAns = 0, bAns = 0;

        Arrays.sort(nums);

        a = nums[sz/2]; b = nums[(sz-1)/2];

        for(int i=0; i<sz; i++){
            aAns += a > nums[i] ? (a - nums[i]) : (nums[i] - a);
            bAns += b > nums[i] ? (b - nums[i]) : (nums[i] - b);
        }

        return Math.min(aAns, bAns);
    }
}