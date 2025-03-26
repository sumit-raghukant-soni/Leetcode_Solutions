class Solution {
    public int minMoves2(int[] nums) {
        int sz = nums.length, ans = Integer.MAX_VALUE;
        int a, b, aAns = 0, bAns = 0;

        Arrays.sort(nums);

        a = nums[sz/2]; b = nums[(sz-1)/2];

        for(int i=0; i<sz; i++){
            aAns += Math.abs(a - nums[i]);
            bAns += Math.abs(b - nums[i]);
        }

        return Math.min(aAns, bAns);
    }
}